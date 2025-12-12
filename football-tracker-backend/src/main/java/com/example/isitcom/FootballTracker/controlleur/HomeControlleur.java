package com.example.isitcom.FootballTracker.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlleur {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}