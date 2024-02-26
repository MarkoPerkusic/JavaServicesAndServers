package com.example.project.service;

import java.util.List;
import com.example.project.model.Product;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProductById(Long id);
    Product saveProduct(Product service);
    void deleteProduct(Long id);
    Product updateProduct(Long id, Product updatedProduct);
}
