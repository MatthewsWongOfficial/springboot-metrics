package com.example.tourservice.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

public class MetricsCollector {
    private final Counter createTourSuccess;
    private final Counter createTourFailure;
    private final Counter updateTourSuccess;
    private final Counter deleteTourSuccess;
    private final Counter searchTourSuccess;

    public MetricsCollector(MeterRegistry registry) {
        this.createTourSuccess = Counter.builder("tour.operations")
                .tag("operation", "create")
                .tag("status", "success")
                .description("Number of successful tour creations")
                .register(registry);

        this.createTourFailure = Counter.builder("tour.operations")
                .tag("operation", "create")
                .tag("status", "failure")
                .description("Number of failed tour creations")
                .register(registry);

        this.updateTourSuccess = Counter.builder("tour.operations")
                .tag("operation", "update")
                .tag("status", "success")
                .description("Number of successful tour updates")
                .register(registry);

        this.deleteTourSuccess = Counter.builder("tour.operations")
                .tag("operation", "delete")
                .tag("status", "success")
                .description("Number of successful tour deletions")
                .register(registry);

        this.searchTourSuccess = Counter.builder("tour.operations")
                .tag("operation", "search")
                .tag("status", "success")
                .description("Number of successful tour searches")
                .register(registry);
    }

    public void incrementCreateTourSuccess() {
        createTourSuccess.increment();
    }

    public void incrementCreateTourFailure() {
        createTourFailure.increment();
    }

    public void incrementUpdateTourSuccess() {
        updateTourSuccess.increment();
    }

    public void incrementDeleteTourSuccess() {
        deleteTourSuccess.increment();
    }

    public void incrementSearchTourSuccess() {
        searchTourSuccess.increment();
    }
}