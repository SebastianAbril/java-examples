package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Query Methods
    List<Product> findByValueGreaterThan(Double value);

    //JPLQ
    @Query("SELECT p FROM Product p WHERE p.value >= :minValue AND p.value <= :maxValue")
    List<Product> findProductsByValueBetween(Double minValue, Double maxValue);

    //SQL Nativo
    @Query(value = "SELECT * FROM product WHERE value >= ?1", nativeQuery = true)
    List<Product> findProductsByValueGreaterThan(Double value);
}
