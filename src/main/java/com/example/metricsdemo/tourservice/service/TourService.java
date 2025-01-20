package com.example.tourservice.service;

import com.example.tourservice.config.MetricsCollector;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TourService {
    private final MetricsCollector metricsCollector;

    public TourService(MetricsCollector metricsCollector) {
        this.metricsCollector = metricsCollector;
    }

    public void createTour(Map<String, Object> tourData) {
        try {
            // Simulate processing
            Thread.sleep(100);
            metricsCollector.incrementCreateTourSuccess();
        } catch (Exception e) {
            metricsCollector.incrementCreateTourFailure();
            throw new RuntimeException("Failed to create tour", e);
        }
    }

    public void updateTour(String id, Map<String, Object> tourData) {
        try {
            Thread.sleep(100);
            metricsCollector.incrementUpdateTourSuccess();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void deleteTour(String id) {
        try {
            Thread.sleep(100);
            metricsCollector.incrementDeleteTourSuccess();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void searchTours(Map<String, String> searchParams) {
        try {
            Thread.sleep(100);
            metricsCollector.incrementSearchTourSuccess();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}