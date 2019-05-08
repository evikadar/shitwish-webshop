package com.norestfortheapi.webshop.products.repository;

import com.norestfortheapi.webshop.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductsRepository extends JpaRepository<Product, Long> {



}
