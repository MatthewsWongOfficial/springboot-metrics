package com.example.tourservice.controller;

import com.example.tourservice.service.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/tours")
public class TourController {
    private final TourService tourService;
    private final Random random = new Random();

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping
    public ResponseEntity<?> createTour(@RequestBody Map<String, Object> tourData) {
        // Simulate random failures (30% chance)
        if (random.nextDouble() < 0.1) {
            return ResponseEntity.badRequest().body("Tour creation failed");
        }
        tourService.createTour(tourData);
        return ResponseEntity.ok("Tour created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTour(@PathVariable String id, @RequestBody Map<String, Object> tourData) {
        tourService.updateTour(id, tourData);
        return ResponseEntity.ok("Tour updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable String id) {
        tourService.deleteTour(id);
        return ResponseEntity.ok("Tour deleted successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchTours(@RequestParam Map<String, String> searchParams) {
        tourService.searchTours(searchParams);
        return ResponseEntity.ok("Search completed successfully");
    }
}