package com.example.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.project.model.Product;
import com.example.project.model.ServiceProvider;
import com.example.project.service.ProductServiceImpl;
import com.example.project.service.ServiceProviderServiceImpl;

@RestController
@RequestMapping("/index")
public class PageController {

    @Autowired
    private ServiceProviderServiceImpl serviceProviderService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping(value = "/addProvider", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<ServiceProvider> addServiceProvider(@RequestParam String providerName, RedirectAttributes attributes) {
        System.out.println("Received providerName: " + providerName);
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setName(providerName);

        ServiceProvider savedProvider = serviceProviderService.saveServiceProvider(serviceProvider);
        attributes.addFlashAttribute("message", "Provider added successfully");

        return new ResponseEntity<ServiceProvider>(savedProvider, HttpStatus.OK);
    }

    @GetMapping("/providers")
    public List<ServiceProvider> getAllProviders() {
        return serviceProviderService.getAllServiceProviders();
    }

    @GetMapping("/providers/{id}")
    public ResponseEntity<ServiceProvider> getProviderById(@PathVariable Long id) {
        ServiceProvider provider = serviceProviderService.getServiceProviderById(id);
        return ResponseEntity.ok().body(provider);
    }

    @PutMapping("/providers/{id}")
    public ResponseEntity<ServiceProvider> updateProvider(@PathVariable Long id, @RequestBody ServiceProvider providerDetails) {
        ServiceProvider updatedProvider = serviceProviderService.updateServiceProvider(id, providerDetails);
        return ResponseEntity.ok().body(updatedProvider);
    }

    @DeleteMapping("/providers/{id}")
    public ResponseEntity<?> deleteProvider(@PathVariable Long id) {
        serviceProviderService.deleteServiceProvider(id);
        return ResponseEntity.ok().build();
    }

     @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok().body(savedProduct);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
