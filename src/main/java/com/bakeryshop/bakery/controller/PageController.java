package com.bakeryshop.bakery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.List;


import com.bakeryshop.bakery.model.Product;
import com.bakeryshop.bakery.service.ProductService;

@Controller
public class PageController {
    
    @Autowired
    private ProductService productService;
    
    // Mapping for the dashbaord page
    @GetMapping({"/dashboard"})
    public String getDashboard() {
        return "dashboard"; //tells Spring to render "dashboard.html" file
    }

    // Mapping for the form page
    @GetMapping({"/formpage"})
    public String getFormpage() {
        return "bakeryforms"; //tells Spring to render "bakeryforms.html" file
    }

    // Mapping for the home page
    @GetMapping({"/", "/home"})
    public String getHomepage() {
        return "home"; //tells Spring to render "home.html" file
    }

    // Mapping for the products page
    @GetMapping("/products")
    public String getProductsPage(Model model) {
        // Fetch the list of products from the service layer
        List<Product> products = productService.getAllProducts();
        
        // Add the list of products to the model
        model.addAttribute("products", products);

        // Return the view name (products.jsp)
        return "products";
    }
    
}