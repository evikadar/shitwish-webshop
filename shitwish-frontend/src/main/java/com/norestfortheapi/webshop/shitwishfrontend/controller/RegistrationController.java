package com.norestfortheapi.webshop.shitwishfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @GetMapping
    public String registerForm() {
        return "session/registration";
    }

    @PostMapping
    public String register() {

        return "redirect:/";
    }
}
