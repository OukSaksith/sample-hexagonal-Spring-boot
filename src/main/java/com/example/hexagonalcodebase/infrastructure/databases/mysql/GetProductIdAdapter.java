package com.example.hexagonalcodebase.infrastructure.databases.mysql;

import com.example.hexagonalcodebase.domain.model.Product;
import com.example.hexagonalcodebase.domain.ports.outbound.GetProductIdPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetProductIdAdapter implements GetProductIdPort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}