package com.example.productservices.repositories;

import com.example.productservices.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    Optional<Category> findById(Long aLong);

    Category save(Category category);

    Optional<Category> findByValue(String value);

    @Override
    void deleteById(Long categoryId);
}
