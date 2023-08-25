package com.fakestoreapi.apiTest.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @RequestMapping("/{productId}")
    public List<Product> getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId);
    }


}
