package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project.repository.ProductRepository;

import com.example.project.model.Product;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository serviceRepository;

    @Override
    public List<Product> getAllServices() {
        return serviceRepository.findAll();

    }

    @Override
    public Product getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }


    @Override
    public Product saveService(Product serv) {
        return serviceRepository.save(serv);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
