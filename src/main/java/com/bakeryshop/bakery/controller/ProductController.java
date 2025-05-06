
package com.bakeryshop.bakery.controller;

import com.bakeryshop.bakery.service.ProductService;
import com.bakeryshop.bakery.model.Product;
import com.bakeryshop.bakery.repository.ProductRepository;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {

        System.out.println("\nInside viewProducts controller method\n");
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        // return "products";  // Gives products.html instead of products.jsp 
        return "products"; // This will load: webapp/WEB-INF/views/products.jsp
    }

    // Output of Inner Join Query on Products table and Orders Table
    // This will return a list of order and product details 
    @GetMapping("/order-product-details")
    public List<ProductRepository.OrderProductView> getOrderProductDetails() {
        return productService.getOrderProductDetails();
    } 

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        try {
            System.out.println("Creating product: " + product);
            logger.info("Creating product: {}", product);
            return productService.save(product);
        } catch (Exception e) {
            logger.error("Error creating product", e);
            throw e; // Rethrow the exception after logging
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.findById(id)
                .map(product -> {
                    // Use the name from productDetails if it's not empty, otherwise retain the current title
                    if (productDetails.getName() != null && !productDetails.getName().isEmpty()) {
                        product.setName(productDetails.getName());
                    };
                    if (productDetails.getPrice() != 0 ) {
                        product.setPrice(productDetails.getPrice());
                    };
                    if (productDetails.getCategory() != null  && !productDetails.getCategory().isEmpty()){
                        product.setCategory(productDetails.getCategory());
                    };
                    if (productDetails.getStock() != 0 ) {
                        product.setStock(productDetails.getStock());
                    };

                    Product updatedProduct = productService.save(product);
                    return ResponseEntity.ok().body(updatedProduct);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

/* If you get an error like "productRepository cannot be resolved", it means that productRepository is being referenced directly in the
 * ProductController.java file, but it is not defined in the class.
 * This can be fixed by declaring or injecting the productRepository in the ProductController class, as shown below:
 * @Autowired  private ProductRepository productRepository;
* This will allow you to use the productRepository in the ProductController class.
*/

/*
 * NOTE: The following code is commented out because we are using REST API endpoints instead of JSP views.
 * If you want to use JSP views, you can uncomment and modify the code as needed.
 * If JSP views are used, the @RestController annotation on the class should be replaced with @Controller.
 * This is because @RestController is used for REST APIs and automatically serializes return values into JSON,
 * while @Controller is used for rendering views.
 * Additionally, the method should return the name of the JSP file (e.g., "products") that corresponds to the view to be rendered.
 * The returned view name would resolve to a JSP file located at webapp/WEB-INF/views/products.jsp
 * For example, return "products" for the products.jsp view.
 */     
    /*
    @GetMapping("/products")
    public String viewProducts(Model model) {

        System.out.println("\nInside viewProducts controller method\n HELLO");
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        // return "products";  // Trying out products.html instead of products.jsp 
        return "products"; // This will load: webapp/WEB-INF/views/products.jsp
    }
    */