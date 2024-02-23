package com.example.project.service;

import java.util.List;
import com.example.project.model.ServiceProvider;

public interface ServiceProviderService {
    List<ServiceProvider> getAllServiceProviders();
    ServiceProvider getServiceProviderById(Long id);
    ServiceProvider saveServiceProvider(ServiceProvider serviceProvider);
    void deleteServiceProvider(Long id);
}
