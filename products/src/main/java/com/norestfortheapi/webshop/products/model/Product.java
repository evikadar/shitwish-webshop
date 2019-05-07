package com.norestfortheapi.webshop.products.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private Long id;
    private String name;
    private ProductCategory productCategory;
    private double price;
    private String description;
    private String imagePath;

}
