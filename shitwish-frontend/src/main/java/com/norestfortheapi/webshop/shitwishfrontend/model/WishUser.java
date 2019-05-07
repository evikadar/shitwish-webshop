package com.norestfortheapi.webshop.shitwishfrontend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishUser {
    long id;
    String name;
    String password;
    String address;
    String email;
}
