package com.example.productservices.services;

import com.example.productservices.models.Product;
import java.util.*;
public interface productService {

    Product getSingleProduct( Long productId );

    List<Product> getAllProduct();

    Product createProduct( Product product);

    void deleteProduct( Long productId ,Product product);

    void replaceProduct( Long productId,Product product);
}
