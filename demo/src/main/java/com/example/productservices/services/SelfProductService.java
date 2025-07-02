package com.example.productservices.services;

import com.example.productservices.exceptions.ProductNotFoundException;
import com.example.productservices.models.Category;
import com.example.productservices.models.Product;
import com.example.productservices.repositories.CategoryRepository;
import com.example.productservices.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements productService{

    // This is a self-implemented product service that does not interact with any database or external system.
private ProductRepository productRepository;
private CategoryRepository categoryRepository;
public SelfProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository)  {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        // This method retrieves a single product by its ID.
        // If the product is not found, it throws a ProductNotFoundException.

        // Using the productRepository to find the product by ID
    Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException(productId);
        }


    }

    @Override
    public List<Product> getAllProduct() {
        // This method retrieves all products.
        // Using the productRepository to find all products
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product createProduct(Product product) {

        if (product.getCategory() != null) {
//        create category first
            Category category = product.getCategory();
            String categoryValue = category.getValue();
            Optional<Category> existingCategory = categoryRepository.findByValue(categoryValue);
            if (existingCategory.isPresent()) {
                product.setCategory(existingCategory.get());
            } else {
                // If the category does not exist, save it
                Category savedCategory = categoryRepository.save(category);
                product.setCategory(savedCategory);


            }

            // Save the product using the productRepository


        }
        return productRepository.save(product);
        // This method creates a new product.
        // It uses the productRepository to save the product to the database.
        // The productRepository will handle the actual storage and retrieval of products.
    }
    @Override
    public void deleteProduct( Long productId) {

    }

    @Override
    public void replaceProduct( Long productId, Product product) {

    }
}
