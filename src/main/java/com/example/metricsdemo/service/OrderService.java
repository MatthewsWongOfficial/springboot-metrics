package com.example.metricsdemo.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderService {
    private final Counter successfulOrders;
    private final Counter failedOrders;
    private final Timer orderProcessingTime;
    private final Random random = new Random();

    public OrderService(PrometheusMeterRegistry registry) {
        // Register metrics in the shared registry
        this.successfulOrders = Counter.builder("orders.status")
                .tag("status", "successful")
                .description("Number of successfully processed orders")
                .register(registry);
        
        this.failedOrders = Counter.builder("orders.status")
                .tag("status", "failed")
                .description("Number of failed orders")
                .register(registry);
        
        this.orderProcessingTime = Timer.builder("orders.processing.time")
                .description("Time taken to process orders")
                .register(registry);
    }

    public void processOrder(String orderId, double amount) {
        Timer.Sample sample = Timer.start();

        try {
            // Simulate processing time
            Thread.sleep(random.nextInt(1900) + 100);

            // Simulate success/failure scenario
            if (random.nextDouble() < 0.8) {
                successfulOrders.increment();
            } else {
                failedOrders.increment();
                throw new RuntimeException("Order processing failed");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            failedOrders.increment();
        } finally {
            sample.stop(orderProcessingTime);
        }
    }
}
