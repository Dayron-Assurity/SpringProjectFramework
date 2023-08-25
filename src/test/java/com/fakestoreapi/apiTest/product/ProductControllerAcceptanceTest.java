package com.fakestoreapi.apiTest.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void findAll() throws Exception {

        List<Product> listOfProductsExpected = List.of(
                new Product(123, "Iphone S12", 50.54, "Phone", "Mobile Phone", "Mobile.img"),
                new Product(124, "TV LED 200", 32.54, "Television", "HD Television", "Television.img"),
                new Product(125, "Lazy Couch", 40.54, "Furniture", "Couch", "Couch.img")
        );

        mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(listOfProductsExpected)));
    }

    @Test
    void getProduct() throws Exception {

        List<Product> listOfProductsExpected = List.of(
                new Product(123, "Iphone S12", 50.54, "Phone", "Mobile Phone", "Mobile.img")
        );

        mockMvc.perform(get("/products/123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(listOfProductsExpected)));
    }
}