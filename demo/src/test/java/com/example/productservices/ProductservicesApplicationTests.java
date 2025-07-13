package com.example.productservices;

import com.example.productservices.repositories.ProductRepository;
import com.example.productservices.repositories.projections.ProductWithTitleAndPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductservicesApplicationTests {
	@Autowired
     private ProductRepository productRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void TestQuery() {
		ProductWithTitleAndPrice productWithTitleAndPrice = productRepository.getTitleAndPricesById(1L);
		System.out.println("Product Title: " + productWithTitleAndPrice.getTitle());
		System.out.println("Product Price: " + productWithTitleAndPrice.getPrice());

		// This test will ensure that the product service is loaded correctly
		// and can be autowired into the application context.
		// You can add more specific tests for productService methods here.
	}


}
