package com.norestfortheapi.webshop.products.controller;


import com.norestfortheapi.webshop.products.model.Product;
import com.norestfortheapi.webshop.products.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    private Environment environment;

    @GetMapping("/product/:id")
    public Product getProduct() {
        return null;
    }

    @Data
    @AllArgsConstructor
    public class Avatar {
        private String image;
        private String port;
    }


}

