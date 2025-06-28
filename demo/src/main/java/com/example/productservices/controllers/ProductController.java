package com.example.productservices.controllers;

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
    public ResponseEntity<Product>  getSingleProduct(@PathVariable("id") Long productId ){
//here we use ResponseEntity for representing complete http response with status code
     return new ResponseEntity<>(productservice.getSingleProduct(productId), HttpStatus.OK);

    }
    @GetMapping()
    public List<Product> getAllProduct(){
        return  productservice.getAllProduct();
    }
    @PostMapping
    public Product createProduct( @RequestBody Product product){
     return new Product();
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
