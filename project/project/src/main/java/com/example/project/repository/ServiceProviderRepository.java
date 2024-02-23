package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.model.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
    
}
