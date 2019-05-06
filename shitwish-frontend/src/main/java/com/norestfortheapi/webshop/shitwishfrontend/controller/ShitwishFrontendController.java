package com.norestfortheapi.webshop.shitwishfrontend.controller;

import com.norestfortheapi.webshop.shitwishfrontend.model.Product;
import com.norestfortheapi.webshop.shitwishfrontend.service.ServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShitwishFrontendController {

    private HttpSession session;

    @Autowired
    private ServiceCaller serviceCaller;

    @GetMapping("/")
    public String displayPage(Model model){
        List<Product> products = serviceCaller.getProductList();
        model.addAttribute("products", products);
        return "index";
    }
}
