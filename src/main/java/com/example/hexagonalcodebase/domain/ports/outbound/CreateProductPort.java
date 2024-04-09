package com.example.hexagonalcodebase.domain.ports.outbound;

import com.example.hexagonalcodebase.domain.model.Product;

public interface CreateProductPort {
    void createProduct(Product product);
}
