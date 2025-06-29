package com.example.productservices.exceptions;

public class ProductNotFoundException extends RuntimeException {
    private final Long productId;

    public ProductNotFoundException(Long productId) {
        super("Product with ID " + productId + " not found.");
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

}
