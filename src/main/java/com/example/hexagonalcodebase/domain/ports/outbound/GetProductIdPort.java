package com.example.hexagonalcodebase.domain.ports.outbound;

import com.example.hexagonalcodebase.domain.model.Product;

import java.util.Optional;

public interface GetProductIdPort {
    Optional<Product> getProductById(Long id);
}
