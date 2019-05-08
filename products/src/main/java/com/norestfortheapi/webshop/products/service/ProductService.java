package com.norestfortheapi.webshop.products.service;

import com.norestfortheapi.webshop.products.model.Product;
import com.norestfortheapi.webshop.products.model.ProductCategory;
import com.norestfortheapi.webshop.products.repository.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {

    @Autowired
    ProductsRepository productRepository;

    public void addNewProducts() {
        Product stone = Product.builder()
                .name("A Stone")
                .price(0.8)
                .productCategory(ProductCategory.UNREMARKABLE_GIFTS)
                .description("A rock he picked up on the walk to meet me. Not even a cute one. Just a regular rock.")
                .imagePath("https://www.thegardenstore.sg/image/cache/catalog/products/Paving%20Slabs/P35M-250x300.png")
                .build();
        Product animalButts = Product.builder()
                .name("Animal Butt Magnets")
                .price(8)
                .productCategory(ProductCategory.ANNOYING_GIFTS)
                .description("For Christmas one year, my oh-so-loving husband gifted me a package of animal butt magnets. Eight magnets, just the backside?")
                .imagePath("https://img.buzzfeed.com/buzzfeed-static/static/2019-04/22/18/asset/buzzfeed-prod-web-01/sub-buzz-9747-1555970551-1.jpg?downsize=800:*&output-format=auto&output-quality=auto")
                .build();
        Product rice = Product.builder()
                .name("Bag Of Rice")
                .price(2)
                .productCategory(ProductCategory.UNREMARKABLE_GIFTS)
                .description("My boyfriend in 10th grade gave me a 10-pound bag of rice for Valentine's Day. He gave it to me early in the day and was like, 'I was kind of tired of carrying it around.' I donated it to the local food bank and we broke up soon after.")
                .imagePath("https://i0.wp.com/www.chidoham.com/wp-content/uploads/2016/02/half-rice-bag.jpg?fit=612%2C444&ssl=1")
                .build();
        Product breakUpText = Product.builder()
                .name("Breakup Text")
                .price(2)
                .productCategory(ProductCategory.UNREMARKABLE_GIFTS)
                .imagePath("https://scontent-vie1-1.cdninstagram.com/vp/ba2cb649de22b4936081f03a5ac66aec/5D6E6D1D/t51.2885-15/e35/57648991_375647596368045_6739987265225959735_n.jpg?_nc_ht=scontent-vie1-1.cdninstagram.com")
                .build();
        Product stuffedAnimal = Product.builder()
                .name("Dead Dog's Old Stuffed Animal")
                .price(4)
                .productCategory(ProductCategory.UNREMARKABLE_GIFTS)
                .description("My high school boyfriend gave me his dead dog’s old stuffed animal for my 15th birthday. And he INSISTED that he bought it at Target, even though it had chew marks on it and its left eye was missing. We broke up shortly after.\"")
                .imagePath("https://i.pinimg.com/originals/51/cd/83/51cd830fef774cb84d9b0e48e4b90cf4.jpg")
                .build();
        Product painting = Product.builder()
                .name("This...one-of-a-kind painting.")
                .price(35)
                .productCategory(ProductCategory.STUPID_GIFTS)
                .imagePath("https://img.buzzfeed.com/buzzfeed-static/static/2019-04/22/17/asset/buzzfeed-prod-web-05/sub-buzz-18861-1555970021-1.jpg?downsize=700%3A%2A&output-quality=auto&output-format=auto")
                .build();
        Product eyepad = Product.builder()
                .name("Thanks for the Ipad")
                .price(7)
                .productCategory(ProductCategory.STUPID_GIFTS)
                .imagePath("https://scontent-vie1-1.cdninstagram.com/vp/e868e448b1858305b6e583f63db81a25/5D6AE4C4/t51.2885-15/e35/23967387_135505530490803_8617812382904745984_n.jpg?_nc_ht=scontent-vie1-1.cdninstagram.com")
                .build();
        Product songbook = Product.builder()
                .name("Frozen Songbook")
                .price(12)
                .productCategory(ProductCategory.ANNOYING_GIFTS)
                .imagePath("https://scontent-vie1-1.cdninstagram.com/vp/52b5854f58b884622a4ac201351d130b/5D53FE73/t51.2885-15/e35/45360967_1339763319499947_2089129913200408882_n.jpg?_nc_ht=scontent-vie1-1.cdninstagram.com")
                .build();
        productRepository.save(stone);
        productRepository.save(painting);
        productRepository.save(animalButts);
        productRepository.save(rice);
        productRepository.save(breakUpText);
        productRepository.save(stuffedAnimal);
        productRepository.save(eyepad);
        productRepository.save(songbook);
    }

    public Product getProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    public List<Product> getEveryProduct() {
//         addNewProducts();
        List<Product> productsSql = productRepository.findAll();
        return productsSql;
    }

}
