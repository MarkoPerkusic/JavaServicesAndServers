package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.project.model.Product;
import com.example.project.service.ProductService;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/services")
class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllServices() {
        return service.getAllServices();
    }

    @GetMapping("/{id}")
    public Product getServiceById(@PathVariable Long id) {
        return service.getServiceById(id);
    }

    @PostMapping
    public Product saveService(@RequestBody Product newService) {
        return service.saveService(newService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        service.deleteService(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/error")
    public String handleError() {
        // Ovdje možete implementirati logiku za prikaz detalja greške
        return "Dogodila se greška. Molimo kontaktirajte administratora.";
    }
}
