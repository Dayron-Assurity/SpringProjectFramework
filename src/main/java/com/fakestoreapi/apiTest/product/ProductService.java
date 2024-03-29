package com.fakestoreapi.apiTest.product;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProduct(int Id){
        return productRepository.getProduct(Id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
