package com.example.products.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void gettersAndSetters() {
        Product p = new Product();
        UUID id = UUID.randomUUID();
        p.setId(id);
        p.setName("Test Product");

        assertEquals(id, p.getId());
        assertEquals("Test Product", p.getName());
    }
}

