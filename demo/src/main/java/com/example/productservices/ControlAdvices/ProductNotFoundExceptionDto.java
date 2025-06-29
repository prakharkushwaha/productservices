package com.example.productservices.ControlAdvices;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundExceptionDto {
    private String message;
    private String errorCode;
    private Long productId;

    public ProductNotFoundExceptionDto(String message, String errorCode, Long productId) {
        this.message = message;
        this.errorCode = errorCode;
        this.productId = productId;
    }
}
