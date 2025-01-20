package com.example.tourservice.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {
    @Bean
    public MetricsCollector metricsCollector(MeterRegistry registry) {
        return new MetricsCollector(registry);
    }
}