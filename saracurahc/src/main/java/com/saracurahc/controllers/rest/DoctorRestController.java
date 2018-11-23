package com.saracurahc.controllers.rest;

import com.saracurahc.models.DoctorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DoctorRestController {

    int WORK_DAY_MINUTES = 360;

    @Autowired
    DoctorDAO doctorDAO;

    @RequestMapping(value = "/getDoctorsBySpeciality/{speciality}", method = GET)
    @ResponseBody
    public List<Map<String, Object>> getDoctorsBySpeciality(@PathVariable("speciality") String speciality){
        return doctorDAO.findBySpeciality(speciality);
    }

//    insert into event(doctor_associated, type, title, beginDate, endDate)
//    values(1, 1, 'Consulta Médica', '2018-11-24T13:00:00', '2018-11-24T13:20:00');

    @RequestMapping(value = "/generateDoctorSchedule/{doctorID}/{workScale}/{startHour}", method = GET)
    @ResponseBody
    public String getDoctorsBySpeciality(@PathVariable("doctorID") String doctorID, @PathVariable("workScale") Integer workScale, @PathVariable("startHour") Integer startHour){
        String response = "";
        try {

            SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
            String dateString = dayFormat.format(new Date());
            String hourString;

            String startDateString = startHour + ":00:00";
            Date date = hourFormat.parse(startDateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            hourString = hourFormat.format(calendar.getTime());

            int numAppointmets = WORK_DAY_MINUTES / workScale;
            for (int i = 0; i < numAppointmets; i++){
                response = "";
                response += "insert into event(doctor_associated, type, title, beginDate, endDate) \n" +
                "values(" + doctorID + ", 1, 'Consulta Médica', '" + dateString + "T" + hourString + "', '";

                calendar.add(Calendar.MINUTE, workScale);
                hourString = hourFormat.format(calendar.getTime());

                response += dateString + "T" + hourString + "'); \n\n";
                System.out.print(response);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Copy and paste console response to data.sql file";
    }

}
