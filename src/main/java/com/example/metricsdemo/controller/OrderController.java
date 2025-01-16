package com.example.metricsdemo.controller;

import com.example.metricsdemo.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/process")
    public String processOrder(@RequestParam String orderId, @RequestParam double amount) {
        try {
            orderService.processOrder(orderId, amount);
            return "Order processed successfully";
        } catch (Exception e) {
            return "Order processing failed: " + e.getMessage();
        }
    }
}