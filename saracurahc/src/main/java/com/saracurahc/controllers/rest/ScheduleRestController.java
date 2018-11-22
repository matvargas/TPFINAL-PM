package com.saracurahc.controllers.rest;

import com.saracurahc.models.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ScheduleRestController {

    @Autowired
    EventDAO eventDAO;

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

}
