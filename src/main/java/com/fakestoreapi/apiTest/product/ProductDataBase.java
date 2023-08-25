package com.fakestoreapi.apiTest.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDataBase implements ProductRepository{

    public List<Product> findAll() {
        return listOfProducts;
    }

    public List<Product> getProduct(int Id) {

        for (Product product : listOfProducts) {
            if (product.getId() == Id){
                return List.of(product);
            }
        }
        return null;
    }
}
