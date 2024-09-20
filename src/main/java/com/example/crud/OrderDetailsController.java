package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-details")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping
    public OrderDetails createOrderDetails(@RequestBody OrderDetailsDTO orderDetailsDTO) {
        return orderDetailsService.createOrderDetails(
                orderDetailsDTO.getOrderID(),
                orderDetailsDTO.getProductId(),
                orderDetailsDTO.getUnitPrice(),
                orderDetailsDTO.getQuantity(),
                orderDetailsDTO.getDiscount()
        );
    }
}
