package com.fakestoreapi.apiTest.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository {

    @Autowired
    List<Product> listOfProducts = List.of(
            new Product(123, "Iphone S12", 50.54, "Phone", "Mobile Phone", "Mobile.img"),
            new Product(124, "TV LED 200", 32.54, "Television", "HD Television", "Television.img"),
            new Product(125, "Lazy Couch", 40.54, "Furniture", "Couch", "Couch.img")
    );
    List<Product> findAll();

    List<Product> getProduct(int Id);
}
