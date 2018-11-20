package com.saracurahc.controllers;

import com.saracurahc.models.DoctorDAO;
import com.saracurahc.models.SpecialityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class DashboardController {

    @Autowired
    SpecialityDAO specialityDAO;

    @Autowired
    DoctorDAO doctorDAO;

    @GetMapping("/")
    public String homePage(Model model) {
        return "dashboardView";
    }

    @GetMapping("/appointment")
    public String appointmentPage(Model model) {
        List<Map<String, Object>> specialities = specialityDAO.getAll();
        model.addAttribute("specialities", specialities);
        return "appointmentView";
    }

}