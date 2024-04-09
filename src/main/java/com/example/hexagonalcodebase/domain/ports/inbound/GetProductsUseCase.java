package com.example.hexagonalcodebase.domain.ports.inbound;

import com.example.hexagonalcodebase.domain.model.Product;
import com.example.hexagonalcodebase.common.exception.ResourceNotFoundException;

import java.util.List;

public interface GetProductsUseCase {
    List<Product> getProducts() throws ResourceNotFoundException;
}
