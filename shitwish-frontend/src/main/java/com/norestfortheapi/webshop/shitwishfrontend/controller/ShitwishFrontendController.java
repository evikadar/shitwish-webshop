package com.norestfortheapi.webshop.shitwishfrontend.controller;

import com.norestfortheapi.webshop.shitwishfrontend.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShitwishFrontendController {

    private HttpSession session;

    @GetMapping("/")
    public String displayPage(Model model){
        List<Product> products = new ArrayList<>();
        Product firstCoffeeThingy = Product.builder().id(1L).name("First").price(10.00).description("Awesome").imagePath("1").build();
        Product secondCoffeeThingy = Product.builder().id(2L).name("Second").price(10.00).description("Awesome").imagePath("2").build();
        products.add(firstCoffeeThingy);
        products.add(secondCoffeeThingy);
        model.addAttribute("products", products);
        return "index";
    }
}
