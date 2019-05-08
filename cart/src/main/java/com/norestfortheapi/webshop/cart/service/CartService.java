package com.norestfortheapi.webshop.cart.service;

import com.norestfortheapi.webshop.cart.model.Cart;
import com.norestfortheapi.webshop.cart.model.CartItem;
import com.norestfortheapi.webshop.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public Cart deleteProductFromCart(Long cartId, Long productId) {
        Cart cart = cartRepository.getOne(cartId);
        List<CartItem> productsInCart = cart.getProducts();
        productsInCart.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .ifPresent(cartItem -> decreaseProductQuantity(cart, cartItem));
        cartRepository.save(cart);
        return cart;
    }

    private void decreaseProductQuantity(Cart cart, CartItem cartItem) {
        int quantity = cartItem.getQuantity();
        if (quantity > 1) {
            cartItem.setQuantity(--quantity);
        } else if (quantity == 1) {
            List<CartItem> products = cart.getProducts();
            products.remove(cartItem);
            cart.setProducts(products);
        }

    }

    public Cart addProductToCart(Long id, Long productId) {
        Cart cart = cartRepository.getOne(id);
        Optional<CartItem> optionalCartItem = cart.getProducts().stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst();
        if (optionalCartItem.isPresent()) {
            CartItem cartItem = optionalCartItem.get();
            increaseProductQuantity(cartItem);
        } else {
            addNewProductToCart(cart, productId);
        }
        cartRepository.save(cart);
        return cart;
    }

    private void addNewProductToCart(Cart cart, Long productId) {
        CartItem cartItem = CartItem.builder()
                .productId(productId)
                .cart(cart)
                .quantity(1)
                .build();
        List<CartItem> products = cart.getProducts();
        products.add(cartItem);
        cartRepository.save(cart);
    }

    private void increaseProductQuantity(CartItem cartItem) {
        cartItem.setQuantity(cartItem.getQuantity() + 1);
    }
}
