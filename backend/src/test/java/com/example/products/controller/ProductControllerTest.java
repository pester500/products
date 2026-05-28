package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Test
    void getProductsReturnsAllProducts() {
        ProductRepository repo = mock(ProductRepository.class);
        Product p1 = new Product();
        p1.setName("A");
        Product p2 = new Product();
        p2.setName("B");
        when(repo.findAll()).thenReturn(Arrays.asList(p1, p2));

        ProductController controller = new ProductController(repo);
        List<Product> list = controller.getProducts();

        assertEquals(2, list.size());
        assertEquals("A", list.get(0).getName());
        assertEquals("B", list.get(1).getName());
        verify(repo, times(1)).findAll();
    }

    @Test
    void createProductSavesAndReturnsProduct() {
        ProductRepository repo = mock(ProductRepository.class);
        Product toSave = new Product();
        toSave.setName("New");
        Product saved = new Product();
        saved.setName("New"); saved.setId(UUID.randomUUID());

        when(repo.save(toSave)).thenReturn(saved);

        ProductController controller = new ProductController(repo);
        Product result = controller.createProduct(toSave);

        assertNotNull(result.getId());
        assertEquals("New", result.getName());
        verify(repo, times(1)).save(toSave);
    }
}

