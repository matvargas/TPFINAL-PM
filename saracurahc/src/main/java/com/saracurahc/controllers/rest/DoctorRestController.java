package com.saracurahc.controllers.rest;

import com.saracurahc.models.DoctorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/generateDoctorSchedule/{doctorID}/{workScale}", method = GET)
    @ResponseBody
    public String getDoctorsBySpeciality(@PathVariable("doctorID") String doctorID, @PathVariable("workScale") Integer workScale){
        String response = "";
        int numAppointmets = WORK_DAY_MINUTES/workScale;
        for (int i = 0; i < numAppointmets; i++){
            response += "insert into event(doctor_associated, type, title, beginDate, endDate)" +
            "values(" + doctorID + ", 1, 'Consulta Médica', '" + new Date().getYear() +
                    "-" +
                    new Date().getMonth() +
                    "-24T13:00:00";
        }
        return response;
    }

}
