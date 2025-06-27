package com.example.productservices.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel{
    private String title;
    private Double price;
    private Category  category;
    private String description;
    private String image;
}
