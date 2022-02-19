package com.bolsaideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // ./mvnw.cmd package
    // java -jar ruta
    @GetMapping("/")
    public String home(){
        return "redirect:/app/index";
    }
}
