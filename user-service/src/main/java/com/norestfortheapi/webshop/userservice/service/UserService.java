package com.norestfortheapi.webshop.userservice.service;

import com.norestfortheapi.webshop.userservice.model.ShitwishUser;
import com.norestfortheapi.webshop.userservice.model.UserAddress;
import com.norestfortheapi.webshop.userservice.repository.ShitwishUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private ShitwishUserRepository userRepository;

    public ShitwishUser getUserById(Long userId) {
        return userRepository.getById(userId);
    }


    public void registerUser(ShitwishUser newUser) {
        UserAddress newAddress = UserAddress.builder().country("").city("").address("").zipCode(0).build();
        newUser.setAddress(newAddress);

        newAddress.setUser(newUser);
        userRepository.save(newUser);
    }
}
