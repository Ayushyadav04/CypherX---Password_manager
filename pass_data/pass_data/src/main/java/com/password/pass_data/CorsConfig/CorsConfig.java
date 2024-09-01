package com.password.pass_data.CorsConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public abstract class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cypher/v1/password-lists")
                .allowedOrigins("http://localhost:5500") // Replace with your frontend origin
                .allowedMethods("GET") // Allowed HTTP methods (e.g., GET, POST)
                .allowedHeaders("*"); // Allowed headers (e.g., Content-Type)
    }

    public abstract void addCorsMAppings(CorsRegistry registry);
}
