package com.bakeryshop.bakery.repository;

import com.bakeryshop.bakery.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSaveAndFindById() {
        Product product = new Product();
        product.setName("Baguette");
        product.setPrice(1.99);
        product.setCategory("Bread");
        product.setStock(30);

        Product saved = productRepository.save(product);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("Baguette");
    }

    @Test
    void testFindAll() {
        Product product1 = new Product();
        product1.setName("Croissant");
        product1.setPrice(2.5);
        product1.setCategory("Pastry");
        product1.setStock(20);

        Product product2 = new Product();
        product2.setName("Muffin");
        product2.setPrice(3.0);
        product2.setCategory("Cake");
        product2.setStock(10);

        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> products = productRepository.findAll();

        assertThat(products).hasSize(2);
    }

    @Test
    void testDeleteById() {
        Product product = new Product();
        product.setName("Tart");
        product.setPrice(4.0);
        product.setCategory("Dessert");
        product.setStock(15);

        Product saved = productRepository.save(product);
        Long id = saved.getId();

        productRepository.deleteById(id);

        assertThat(productRepository.findById(id)).isEmpty();
    }
}
