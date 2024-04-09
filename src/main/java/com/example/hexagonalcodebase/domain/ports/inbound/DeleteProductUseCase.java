package com.example.hexagonalcodebase.domain.ports.inbound;

import com.example.hexagonalcodebase.common.exception.ResourceNotFoundException;

public interface DeleteProductUseCase {
    void deleteProduct(Long id) throws ResourceNotFoundException;
}
