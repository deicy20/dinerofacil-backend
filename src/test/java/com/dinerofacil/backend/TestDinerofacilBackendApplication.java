package com.dinerofacil.backend;

import org.springframework.boot.SpringApplication;

public class TestDinerofacilBackendApplication {

    public static void main(String[] args) {
        SpringApplication.from(DinerofacilBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
