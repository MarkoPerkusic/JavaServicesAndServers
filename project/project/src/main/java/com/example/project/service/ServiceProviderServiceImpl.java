package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project.repository.ServiceProviderRepository;

import com.example.project.model.ServiceProvider;

import java.util.List;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService{
    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Override
    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepository.findAll();

    }

    @Override
    public ServiceProvider getServiceProviderById(Long id) {
        return serviceProviderRepository.findById(id).orElse(null);
    }

    @Override
    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public void deleteServiceProvider(Long id) {
        serviceProviderRepository.deleteById(id);
    }

    @Override
    public ServiceProvider updateServiceProvider(Long id, ServiceProvider updatedProvider) {
        ServiceProvider existingProvider = serviceProviderRepository.findById(id).orElse(null);
        if (existingProvider != null) {
            existingProvider.setName(updatedProvider.getName());
            // Dodajte ažuriranje ostalih polja prema potrebi
            return serviceProviderRepository.save(existingProvider);
        }
        return null;
    }
}
