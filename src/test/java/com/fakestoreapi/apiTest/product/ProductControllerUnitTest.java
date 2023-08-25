package com.fakestoreapi.apiTest.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;
@SpringBootTest
class ProductControllerUnitTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void shouldGetProduct() throws JsonProcessingException {

        List<Product> listOfProducts = List.of(
                new Product(123, "Iphone S12", 50.54, "Phone", "Mobile Phone", "Mobile.img")
        );

        List<Product> listOfProductsExpected = List.of(
                new Product(123, "Iphone S12", 50.54, "Phone", "Mobile Phone", "Mobile.img")
        );

        ProductService productService = Mockito.mock(ProductService.class);

        when(productService.getProduct(1234))
                .thenReturn(listOfProducts);

        ProductController productController = new ProductController(productService);

        Assertions.assertEquals(
                objectMapper.writeValueAsString(listOfProductsExpected),
                objectMapper.writeValueAsString(productController.getProduct(1234))
        );
    }
    @Test
    void shouldGetAllProducts() throws JsonProcessingException {
        List<Product> listOfProducts = List.of(
                new Product(123, "Iphone S12", 50.54, "Phone", "Mobile Phone", "Mobile.img"),
                new Product(124, "TV LED 200", 32.54, "Television", "HD Television", "Television.img"),
                new Product(125, "Lazy Couch", 40.54, "Furniture", "Couch", "Couch.img")
        );

        List<Product> listOfProductsExpected = List.of(
                new Product(123, "Iphone S12", 50.54, "Phone", "Mobile Phone", "Mobile.img"),
                new Product(124, "TV LED 200", 32.54, "Television", "HD Television", "Television.img"),
                new Product(125, "Lazy Couch", 40.54, "Furniture", "Couch", "Couch.img")
        );


        ProductService productService = Mockito.mock(ProductService.class);
        when(productService.findAll())
                .thenReturn(listOfProducts);

        ProductController productController = new ProductController(productService);

        Assertions.assertEquals(
                objectMapper.writeValueAsString(listOfProductsExpected),
                objectMapper.writeValueAsString(productController.findAll())
        );

    }
}