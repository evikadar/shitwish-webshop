package com.norestfortheapi.webshop.cart.repository;

import com.norestfortheapi.webshop.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
