package com.fakestoreapi.apiTest;

import com.fakestoreapi.apiTest.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Uploading in origin
@SpringBootApplication
@RestController
public class ApiTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiTestApplication.class, args);
	}

}
