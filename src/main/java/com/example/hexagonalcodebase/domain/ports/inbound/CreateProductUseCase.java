package com.example.hexagonalcodebase.domain.ports.inbound;

import com.example.hexagonalcodebase.common.exception.GlobalException;
import com.example.hexagonalcodebase.common.exception.ParameterNotFoundException;
import com.example.hexagonalcodebase.domain.model.Product;

public interface CreateProductUseCase {
    void createProduct(Product product) throws ParameterNotFoundException, GlobalException;
}
