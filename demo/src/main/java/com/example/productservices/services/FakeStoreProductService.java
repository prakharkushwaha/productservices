package com.example.productservices.services;

import com.example.productservices.dtos.FakeStoreProductDto;
import com.example.productservices.models.Category;
import com.example.productservices.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Getter 
@Setter
@Service
public class FakeStoreProductService implements productService {
    private  RestTemplate restTemplate; // we will make bean for this

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
//        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProduct() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products/",
                FakeStoreProductDto[].class  //using array because of typeerasure
        );
       List<Product> products= new ArrayList<>();

       for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
           products.add(convertFakeStoreDtoToProduct(fakeStoreProductDto));
       }

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

    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        // Convert String category to Category object
        Category category = new Category();
        category.setValue(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        return product;
    }
}
