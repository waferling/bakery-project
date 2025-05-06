package com.bakeryshop.bakery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakeryshop.bakery.model.Product;
import com.bakeryshop.bakery.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Fetch all products from the repository
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
    return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    // Performing inner join query to fetch order and product details

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductRepository.OrderProductView> getOrderProductDetails() {
        return productRepository.fetchOrderProductDetails();
    }

}