package com.example.productservices.controllers;

import com.example.productservices.exceptions.ProductNotFoundException;
import com.example.productservices.models.Product;
import com.example.productservices.services.productService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController { 

   private productService productservice;
   public ProductController(productService productservice){
      this.productservice=productservice;
   }
 @GetMapping("{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId )throws ProductNotFoundException {
//here we use ResponseEntity for representing complete http response with status code

    return productservice.getSingleProduct(productId);
 }
    @GetMapping()
    public List<Product> getAllProduct(){
        return  productservice.getAllProduct();
    }
    @PostMapping
    public Product createProduct( @RequestBody Product product){
     return productservice.createProduct(product);
    }
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long ProductId){

    }
    @PatchMapping("{id}") //partial update
    public void updateProduct(@PathVariable("id") Long productId ,@RequestBody Product product){

    }
    @PutMapping("{id}") //entire update
    public void repplaceProduct(@PathVariable("id") Long productId ,@RequestBody Product product){

    }
}
