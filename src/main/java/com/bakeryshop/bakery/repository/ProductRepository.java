package com.bakeryshop.bakery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bakeryshop.bakery.model.Product;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT o.orderId AS orderId, p.name AS productName, op.quantity AS quantity " +
           "FROM OrderProducts op " +
           "INNER JOIN op.order o " +
           "INNER JOIN op.product p")
    List<OrderProductView> fetchOrderProductDetails();

    // Projection interface (DTO) to hold the result of the query
    interface OrderProductView {
        Long getOrderId();
        String getProductName();
        Integer getQuantity();
    }
}
