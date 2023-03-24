package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testingThings() {
        Product product1 = new Product("Producto 1", "Descripción del producto 1", 10.0);

        Product dbProdcut = productRepository.save(product1);

        assertThat(dbProdcut).isNotNull();
        assertThat(dbProdcut.getId()).isNotNull();
    }

    @Test
    public void testFindByValueGreaterThan() {
        // Agregar algunos productos de prueba
        Product product1 = new Product("Producto 1", "Descripción del producto 1", 10.0);
        Product product2 = new Product("Producto 2", "Descripción del producto 2", 20.0);
        Product product3 = new Product("Otro producto", "Descripción de otro producto", 30.0);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        // Buscar productos por nombre que contenga "Producto"
        List<Product> products = productRepository.findByValueGreaterThan(22.0);

        // Verificar que se devuelvan los productos correctos
        assertThat(products.size()).isEqualTo(1);
        assertThat(products.get(0).getName()).isEqualTo("Otro producto");
    }

    @Test
    public void testFindProductsByValueBetween() {
        Product product1 = new Product("Product 1", "Description 1", 10.0);
        Product product2 = new Product("Product 2", "Description 2", 20.0);
        Product product3 = new Product("Product 3", "Description 3", 30.0);

        productRepository.saveAll(Arrays.asList(product1, product2, product3));

        List<Product> products = productRepository.findProductsByValueBetween(15.0, 25.0);

        assertThat(products).containsExactly(product2);
    }

    @Test
    public void testFindProductsByValueGreaterThan() {
        Product product1 = new Product("Product 1", "Description 1", 10.0);
        Product product2 = new Product("Product 2", "Description 2", 20.0);
        Product product3 = new Product("Product 3", "Description 3", 30.0);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        List<Product> products = productRepository.findProductsByValueGreaterThan(15.0);

        assertThat(products).hasSize(2);
        assertThat(products).contains(product2, product3);
    }
}
