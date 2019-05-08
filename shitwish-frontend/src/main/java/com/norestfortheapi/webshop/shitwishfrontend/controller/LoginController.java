package com.norestfortheapi.webshop.shitwishfrontend.controller;

import com.norestfortheapi.webshop.shitwishfrontend.model.WishUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@SessionAttributes({"user"})
public class LoginController {

    @ModelAttribute("user")
    public WishUser getUser() {
        return new WishUser();
    }

    @GetMapping
    public String loginForm() {
        return "session/login";
    }

    @PostMapping
    public String login(@ModelAttribute WishUser user) {
        return "redirect:/";
    }
}
