package com.saracurahc.controllers.rest;

import com.saracurahc.models.DoctorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DoctorRestController {

    @Autowired
    DoctorDAO doctorDAO;

    @RequestMapping(value = "/getDoctorsBySpeciality{id}", method = GET)
    @ResponseBody
    public List<Map<String, Object>> getDoctorsBySpeciality(@PathVariable("id") int id){
        return doctorDAO.findBySpeciality(id);
    }

}
