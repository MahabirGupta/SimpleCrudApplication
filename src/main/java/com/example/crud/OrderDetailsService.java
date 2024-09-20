package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository; // Make sure you have a repository for OrderDetails

    @Autowired
    private ProductsRepository productsRepository; // Repository for Products

    public OrderDetails createOrderDetails(Long orderId, Integer productId, Double unitPrice, Integer quantity, Double discount) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderID(orderId);
        orderDetails.setProductId(productId);
        orderDetails.setUnitPrice(unitPrice);
        orderDetails.setQuantity(quantity);
        orderDetails.setDiscount(discount);

        // Fetch the Product object
        Products product = productsRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        orderDetails.setProduct(product);

        return orderDetailsRepository.save(orderDetails);
    }
}

