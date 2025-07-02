package com.example.productservices.repositories;

import com.example.productservices.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.tokens.Token;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // This interface extends JpaRepository to provide CRUD operations for Product entities.
    // It will automatically provide methods like save, findById, findAll, deleteById, etc.
    // No additional methods are needed unless custom queries are required.
    // Additional custom query methods can be defined here if needed.
    // For example, you can add methods like:
    // List<Product> findByName(String name);
    // List<Product> findByCategory(String category);

    // But for now, we are using the default methods provided by JpaRepository.
    @Override
    Optional<Product> findById(Long productId);
    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);
}
