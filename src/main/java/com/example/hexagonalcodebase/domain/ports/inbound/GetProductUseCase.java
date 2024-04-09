package com.example.hexagonalcodebase.domain.ports.inbound;

import com.example.hexagonalcodebase.common.exception.ResourceNotFoundException;
import com.example.hexagonalcodebase.domain.model.Product;

public interface GetProductUseCase {
    Product getProduct(Long id) throws ResourceNotFoundException;
}
