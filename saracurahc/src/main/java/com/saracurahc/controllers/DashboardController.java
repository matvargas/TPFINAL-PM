package com.saracurahc.controllers;

import com.saracurahc.models.SpecialityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
public class DashboardController {

    @Autowired
    SpecialityDAO specialityDAO;

    @GetMapping("/")
    public String homePage(Model model) {
        return "dashboardView";
    }

    @GetMapping("/appointment")
    public String appointmentPage(Model model, @RequestParam(value = "teste", required = false, defaultValue = "") String teste) {
        teste = "tesadasasdsadasdste";
        List<Map<String, Object>> specialities = specialityDAO.getAll();
        model.addAttribute("specialities", specialities);
        model.addAttribute("teste", teste);
        return "appointmentView";
    }
}