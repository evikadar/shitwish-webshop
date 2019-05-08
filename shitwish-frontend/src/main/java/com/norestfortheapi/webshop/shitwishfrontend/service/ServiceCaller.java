package com.norestfortheapi.webshop.shitwishfrontend.service;

import com.norestfortheapi.webshop.shitwishfrontend.model.Cart;
import com.norestfortheapi.webshop.shitwishfrontend.model.Product;
import com.norestfortheapi.webshop.shitwishfrontend.model.WishUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.base}")
    private String baseUrl;

    @Value("${url.products}")
    private String productUrl;

    @Value("${url.users}")
    private String userUrl;

    @Value("${url.carts}")
    private String cartUrl;

    public List<Product> getProductList() {

        try {
            ResponseEntity<List<Product>> productList = restTemplate.exchange(baseUrl + productUrl, HttpMethod.GET,
                    null, new ParameterizedTypeReference<List<Product>>() {
                    });
            return productList.getBody();
        } catch (Exception e) {
            log.error(e.getMessage());
            List<Product> products = new ArrayList<>();
            Product firstCoffeeThingy =
                    Product.builder().id(1L).name("First").price(10.00).description("Awesome").imagePath("1").build();
            Product secondCoffeeThingy =
                    Product.builder().id(2L).name("Second").price(10.00).description("Awesome").imagePath("2").build();
            products.add(firstCoffeeThingy);
            products.add(secondCoffeeThingy);
            return products;
        }
    }

    public Product getProduct(long id) {
        try {
            ResponseEntity<Product> productResponseEntity = restTemplate.exchange(baseUrl + productUrl + "/" + id,
                    HttpMethod.GET
                    , null, new ParameterizedTypeReference<Product>() {
                    });
            return productResponseEntity.getBody();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public WishUser getUser(long id) {
        try {
            ResponseEntity<WishUser> wishUserResponseEntity = restTemplate.exchange(baseUrl + userUrl + "/" + id,
                    HttpMethod.GET
                    , null, new ParameterizedTypeReference<WishUser>() {
                    });
            return wishUserResponseEntity.getBody();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public Cart getCart(long id) {
        try {
            ResponseEntity<Cart> cartResponseEntity = restTemplate.exchange(baseUrl + cartUrl + "/" + id,
                    HttpMethod.GET
                    , null, new ParameterizedTypeReference<Cart>() {
                    });
            return cartResponseEntity.getBody();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

}
