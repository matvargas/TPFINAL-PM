package com.saracurahc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String homePage(Model model) {
        return "dashboard";
    }

    @GetMapping("/appointment")
    public String appointmentPage(Model model) {
        return "appointment";
    }
}