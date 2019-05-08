package com.norestfortheapi.webshop.shitwishfrontend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Scope("session")
public class WishUser {
    private long id;
    private String name;
    private String password;
    private String address;
    private String email;
}
