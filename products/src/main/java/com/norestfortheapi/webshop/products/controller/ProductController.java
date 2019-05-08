package com.norestfortheapi.webshop.products.controller;


import com.norestfortheapi.webshop.products.model.Product;
import com.norestfortheapi.webshop.products.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    private Environment environment;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/")
    public List<Product> getEveryProduct() {
        return productService.getEveryProduct();
    }

}

