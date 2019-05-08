package com.norestfortheapi.webshop.products.service;

import com.norestfortheapi.webshop.products.model.Product;
import com.norestfortheapi.webshop.products.model.ProductCategory;
import com.norestfortheapi.webshop.products.repository.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .imagePath("https://scontent-vie1-1.cdninstagram.com/vp/a6c352049b58f6b2235cd46fd95c4d3a/5D75F9A6/t51.2885-15/e35/s1080x1080/57588270_580720479364453_1586492108105925404_n.jpg?_nc_ht=scontent-vie1-1.cdninstagram.com")
                .build();
        Product animalButts = Product.builder()
                .name("Animal Butt Magnets")
                .price(8)
                .productCategory(ProductCategory.ANNOYING_GIFTS)
                .description("For Christmas one year, my oh-so-loving husband gifted me a package of animal butt magnets. Eight magnets, just the backside?")
                .imagePath("https://thegadgetflow.com/wp-content/uploads/2013/12/Animal-Butt-Magnets-From-Steph-Mantis-4.jpg")
                .build();
        Product rice = Product.builder()
                .name("Bag Of Rice")
                .price(2)
                .productCategory(ProductCategory.UNREMARKABLE_GIFTS)
                .description("My boyfriend in 10th grade gave me a 10-pound bag of rice for Valentine's Day. He gave it to me early in the day and was like, 'I was kind of tired of carrying it around.' I donated it to the local food bank and we broke up soon after.")
                .imagePath("https://www.hybridteck.net/wp-content/uploads/2017/09/bagofrice1.jpg")
                .build();
        Product breakUpText = Product.builder()
                .name("Breakup Text")
                .price(2)
                .description("Just what everyone wishes for their birthday!")
                .productCategory(ProductCategory.UNREMARKABLE_GIFTS)
                .imagePath("https://scontent-vie1-1.cdninstagram.com/vp/91896d7726f705687caa1d5c6cbe57d7/5D69DC3F/t51.2885-15/e35/51393146_623840411397429_7856379322426664951_n.jpg?_nc_ht=scontent-vie1-1.cdninstagram.com")
                .build();
        Product stuffedAnimal = Product.builder()
                .name("Dead Dog's Old Stuffed Animal")
                .price(4)
                .productCategory(ProductCategory.UNREMARKABLE_GIFTS)
                .description("My high school boyfriend gave me his dead dog’s old stuffed animal for my 15th birthday. And he INSISTED that he bought it at Target, even though it had chew marks on it and its left eye was missing. We broke up shortly after.\"")
                .imagePath("https://scontent-vie1-1.cdninstagram.com/vp/a55722d37094ecd9684c786f0ea30dae/5D77D650/t51.2885-15/e35/29740583_276913882848821_5133437558918742016_n.jpg?_nc_ht=scontent-vie1-1.cdninstagram.com")
                .build();
        Product painting = Product.builder()
                .name("This...one-of-a-kind painting.")
                .price(35)
                .description("It's truly ugly and absolutely creepy. The best.")
                .productCategory(ProductCategory.STUPID_GIFTS)
                .imagePath("https://scontent-vie1-1.cdninstagram.com/vp/6a4456002831949e51c4fd5404fcd6a9/5D75C223/t51.2885-15/e35/58453704_2175279742772752_2970356342932356070_n.jpg?_nc_ht=scontent-vie1-1.cdninstagram.com")
                .build();
        Product eyepad = Product.builder()
                .name("Thanks for the Ipad")
                .price(7)
                .description("I asked an Ipad from my grandma for my birthday but I think I didn't specify the model clearly enough.")
                .productCategory(ProductCategory.STUPID_GIFTS)
                .imagePath("https://scontent-vie1-1.cdninstagram.com/vp/e868e448b1858305b6e583f63db81a25/5D6AE4C4/t51.2885-15/e35/23967387_135505530490803_8617812382904745984_n.jpg?_nc_ht=scontent-vie1-1.cdninstagram.com")
                .build();
        Product songbook = Product.builder()
                .name("Frozen Songbook")
                .price(12)
                .description("The best part about it is that as the battery runs out, the life runs out from the melody as well.")
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
        // addNewProducts();
        List<Product> productsSql = productRepository.findAll();
        return productsSql;
    }

}
