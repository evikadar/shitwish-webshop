package com.norestfortheapi.webshop.shitwishfrontend.controller;

import com.norestfortheapi.webshop.shitwishfrontend.model.WishUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/registration")
@SessionAttributes({"user"})
public class RegistrationController {

    /*@ModelAttribute("user")
    public WishUser registerNewUser(){

    }*/

    @GetMapping
    public String loginForm() {
        return "session/registration";
    }
}
