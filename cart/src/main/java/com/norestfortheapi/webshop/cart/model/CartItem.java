package com.norestfortheapi.webshop.cart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(UniqueCartItem.class)
public class CartItem {

    @Id
    @Column(name = "product_id")
    private Long productId;

    private int quantity;

    @Id
    @ManyToOne
    @JsonIgnoreProperties({"products"})
    private Cart cart;
}
