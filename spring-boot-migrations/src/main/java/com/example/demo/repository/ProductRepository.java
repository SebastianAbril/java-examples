package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    // Aqui se pueden incluir metodos personalizados para consultas.
    // Se puede usar tanto JPQL como SQL nativo.

    List<Product> findByValueGreaterThan(Double value);
    List<Product> findByName(String name);
}
