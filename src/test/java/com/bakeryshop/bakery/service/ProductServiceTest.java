package com.bakeryshop.bakery.service;

import com.bakeryshop.bakery.model.Product;
import com.bakeryshop.bakery.repository.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product sampleProduct;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleProduct = new Product();
        sampleProduct.setId(1L);
        sampleProduct.setName("Croissant");
        sampleProduct.setPrice(2.5);
        sampleProduct.setCategory("Pastry");
        sampleProduct.setStock(50);
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = Arrays.asList(sampleProduct);
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();

        assertEquals(1, result.size());
        assertEquals("Croissant", result.get(0).getName());
    }

    @Test
    void testFindById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));

        Optional<Product> result = productService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Croissant", result.get().getName());
    }

    @Test
    void testSave() {
        when(productRepository.save(sampleProduct)).thenReturn(sampleProduct);

        Product result = productService.save(sampleProduct);

        assertNotNull(result);
        assertEquals("Croissant", result.getName());
    }

    @Test
    void testDeleteById() {
        productService.deleteById(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }
}
