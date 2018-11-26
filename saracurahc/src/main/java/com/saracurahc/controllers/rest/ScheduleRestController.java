package com.saracurahc.controllers.rest;

import com.saracurahc.Objects.Patient;
import com.saracurahc.models.EventDAO;
import com.saracurahc.models.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ScheduleRestController {

    @Autowired
    EventDAO eventDAO;

    @Autowired
    PatientDAO patientDAO;

    @RequestMapping(value = "/getAllEvents", method = GET)
    @ResponseBody
    public List<Map<String, Object>> getAllEvents(){
        return eventDAO.getAll();
    }

    @RequestMapping(value = "/getEventsByDoctorName/{doctorName}", method = GET)
    @ResponseBody
    public List<Map<String, Object>> getEventsByDoctorName(@PathVariable("doctorName") String doctorName){
        return eventDAO.getEventsByDoctorName(doctorName);
    }

    @RequestMapping(value = "/confirmAppontmentParticular/{paymentForm}/{patientName}/{patientPhone}", method = GET)
    @ResponseBody
    public boolean confirmAppontmentParticular(@PathVariable("paymentForm") String paymentForm, @PathVariable("patientName") String patientName, @PathVariable("patientPhone") String patientPhone){
        Random random = new Random();
        boolean result = random.nextBoolean();

        if(result) {
            Patient patient = new Patient();
            patient.setName(patientName);
            patient.setPhoneNumber(patientPhone);
        }

        return result;
    }

}
