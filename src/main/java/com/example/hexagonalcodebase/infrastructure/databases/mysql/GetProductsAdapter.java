package com.example.hexagonalcodebase.infrastructure.databases.mysql;

import com.example.hexagonalcodebase.domain.model.Product;
import com.example.hexagonalcodebase.domain.ports.outbound.GetProductsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetProductsAdapter implements GetProductsPort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}