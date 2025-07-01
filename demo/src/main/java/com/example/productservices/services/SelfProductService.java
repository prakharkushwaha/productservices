package com.example.productservices.services;

import com.example.productservices.exceptions.ProductNotFoundException;
import com.example.productservices.models.Product;
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
public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
        return null;
    }

    @Override
    public void deleteProduct(Long productId, Product product) {

    }

    @Override
    public void replaceProduct(Long productId, Product product) {

    }
}
