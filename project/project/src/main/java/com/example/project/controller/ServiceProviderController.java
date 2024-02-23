package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import com.example.project.model.ServiceProvider;
import com.example.project.service.ServiceProviderService;

import java.util.List;


@RestController
@RequestMapping("/serviceproviders")
public class ServiceProviderController {
    @Autowired
    private ServiceProviderService serviceProviderService;

    @GetMapping
    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderService.getAllServiceProviders();
    }

    @GetMapping("/{id}")
    public ServiceProvider getServiceProviderrById(@PathVariable Long id) {
        return serviceProviderService.getServiceProviderById(id);
    }

    @PostMapping
    public ServiceProvider saveServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        return serviceProviderService.saveServiceProvider(serviceProvider);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceProvider(@PathVariable Long id) {
        serviceProviderService.deleteServiceProvider(id);
    }

    @PostMapping("/serviceproviders/add")
    //public ServiceProvider addServiceProvider(@RequestBody ServiceProvider serviceProvider) {
    //    return serviceProviderService.saveServiceProvider(serviceProvider);
    //}
    public ResponseEntity<ServiceProvider> addServiceProvider(@RequestBody ServiceProvider serviceProvider) {

        System.out.println("Received Request Body:");
        System.out.println(serviceProvider.toString());

        ServiceProvider savedProvider = serviceProviderService.saveServiceProvider(serviceProvider);
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(savedProvider);
    }
}
