package com.fakestoreapi.apiTest.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private ProductService productService;

    @Test
    void findAll() throws Exception {

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

        when(productService.findAll()).
                thenReturn(listOfProducts);
        mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(listOfProductsExpected)));
        verify(productService).findAll();


    }

    @Test
    void getProduct() throws Exception {

        List<Product> listOfProducts = List.of(
                new Product(123, "Iphone S12", 50.54, "Phone", "Mobile Phone", "Mobile.img")
        );

        List<Product> listOfProductsExpected = List.of(
                new Product(123, "Iphone S12", 50.54, "Phone", "Mobile Phone", "Mobile.img")
        );

        when(productService.getProduct(123)).
                thenReturn(listOfProducts);
        mockMvc.perform(get("/products/123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(listOfProductsExpected)));
        verify(productService).getProduct(123);
    }
}