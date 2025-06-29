package com.example.productservices.ControlAdvices;
import com.example.productservices.exceptions.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // This class will handle exceptions globally for all controllers
    // You can define methods here to handle specific exceptions and return custom responses

    // Example method to handle ProductNotFoundException
    // @ExceptionHandler(ProductNotFoundException.class)
    // public ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex) {
    //     return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    // }
    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFound(ProductNotFoundException ex) {
        // You can log the exception or perform other actions here
        // For now, we will just return the exception message as a string
        return new ResponseEntity<>(
                new ProductNotFoundExceptionDto(ex.getMessage(), "PRODUCT_NOT_FOUND", ex.getProductId()),
                org.springframework.http.HttpStatus.NOT_FOUND
        );

    }



}
