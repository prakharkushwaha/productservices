package com.example.productservices.repositories;

import com.example.productservices.models.Product;
import com.example.productservices.repositories.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(" SELECT  p.title AS title, p.price AS price  FROM products p WHERE p.id = :id")

    ProductWithTitleAndPrice getTitleAndPricesById(@Param("id") Long productId);
//    @Query("SELECT p.title AS title, p.price AS price FROM products p WHERE p.id = :id") specifies a JPQL query to fetch only the title and price fields from the products table where the product's id matches the given parameter.
//    ProductWithTitleAndPrice getTitleAndPricesById(@Param("id") Long productId); declares a method that executes the above query, returning a projection (ProductWithTitleAndPrice) containing only the title and price for the specified product ID.
//    This approach is used to fetch partial data (not the entire entity) efficiently.
}

