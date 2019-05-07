package com.norestfortheapi.webshop.products.service;

import com.norestfortheapi.webshop.products.model.Product;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class ProductService {

    public Product getProduct() {
        Product firstCoffeeThingy = Product.builder().id(1L).name("First").price(10.00).description("Awesome").imagePath("1").build();
        return firstCoffeeThingy;
    }

}
