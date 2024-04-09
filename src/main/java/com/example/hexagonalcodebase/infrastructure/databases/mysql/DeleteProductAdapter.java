package com.example.hexagonalcodebase.infrastructure.databases.mysql;

import com.example.hexagonalcodebase.domain.model.Product;
import com.example.hexagonalcodebase.domain.ports.outbound.DeleteProductPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductAdapter implements DeleteProductPort {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}