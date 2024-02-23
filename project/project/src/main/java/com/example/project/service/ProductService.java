package com.example.project.service;

import java.util.List;
import com.example.project.model.Product;

public interface ProductService {
    List<Product> getAllServices();
    Product getServiceById(Long id);
    Product saveService(Product service);
    void deleteService(Long id);
}
