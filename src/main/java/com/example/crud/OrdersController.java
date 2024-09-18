package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // CREATE a new Order and link it to a Customer
    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestParam Long customerId, @RequestBody Orders order) {
        // Find the customer by ID
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Set the customer for the order
        order.setCustomer(customer);

        // Save the order
        Orders savedOrder = ordersRepository.save(order);

        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    // READ all Orders
    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    // READ an Order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        Optional<Orders> order = ordersRepository.findById(id);
        return order.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE an Order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable Long id) {
        try {
            ordersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE all Orders
    @DeleteMapping("/all")
    public ResponseEntity<HttpStatus> deleteAllOrders() {
        try {
            ordersRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // UPDATE an Order by ID
    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long id, @RequestBody Orders updatedOrder) {
        Optional<Orders> orderData = ordersRepository.findById(id);

        if (orderData.isPresent()) {
            Orders order = orderData.get();
            order.setCustomer(updatedOrder.getCustomer()); // Assuming you've mapped the customer
            order.setEmployeeId(updatedOrder.getEmployeeId());
            order.setOrderDate(updatedOrder.getOrderDate());
            order.setRequiredDate(updatedOrder.getRequiredDate());
            order.setShipDate(updatedOrder.getShipDate());
            order.setShipVia(updatedOrder.getShipVia());
            order.setShipName(updatedOrder.getShipName());
            order.setShipAddress(updatedOrder.getShipAddress());
            order.setShipCity(updatedOrder.getShipCity());
            order.setShipCountry(updatedOrder.getShipCountry());
            order.setShipRegion(updatedOrder.getShipRegion());
            order.setShipPostalCode(updatedOrder.getShipPostalCode());

            return new ResponseEntity<>(ordersRepository.save(order), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
