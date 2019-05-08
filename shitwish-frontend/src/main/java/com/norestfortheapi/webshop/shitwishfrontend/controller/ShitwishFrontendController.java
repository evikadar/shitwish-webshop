package com.norestfortheapi.webshop.shitwishfrontend.controller;

import com.norestfortheapi.webshop.shitwishfrontend.model.Cart;
import com.norestfortheapi.webshop.shitwishfrontend.model.Product;
import com.norestfortheapi.webshop.shitwishfrontend.model.WishUser;
import com.norestfortheapi.webshop.shitwishfrontend.service.ServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"cart", "user"})
public class ShitwishFrontendController {

    @ModelAttribute("user")
    public WishUser getUser() {
        return new WishUser(0, "Guest", "1111", "N/A", "N/A");
    }

    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

    @Autowired
    private ServiceCaller serviceCaller;

    @GetMapping("/")
    public String displayPage(Model model, @ModelAttribute WishUser user, @ModelAttribute Cart cart) {
        List<Product> products = serviceCaller.getProductList();
        try {
            cart = serviceCaller.getCart(user.getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        model.addAttribute("products", products);
        model.addAttribute("cart", cart);
        return "index";
    }
}
