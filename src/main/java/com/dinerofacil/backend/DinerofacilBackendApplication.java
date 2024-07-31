package com.dinerofacil.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.dinerofacil.backend.repository")
public class DinerofacilBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DinerofacilBackendApplication.class, args);
    }

}
