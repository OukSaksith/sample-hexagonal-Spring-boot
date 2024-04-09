package com.example.hexagonalcodebase.domain.services;

import com.example.hexagonalcodebase.common.constants.ProductConstanst;
import com.example.hexagonalcodebase.common.customannotation.UseCase;
import com.example.hexagonalcodebase.common.exception.ResourceNotFoundException;
import com.example.hexagonalcodebase.domain.model.Product;
import com.example.hexagonalcodebase.domain.ports.inbound.GetProductUseCase;
import com.example.hexagonalcodebase.domain.ports.outbound.GetProductIdPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@UseCase
public class GetProductService implements GetProductUseCase {

    private GetProductIdPort getProductIdPort;

    @Override
    public Product getProduct(Long id) throws ResourceNotFoundException {
        return getProductIdPort.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ProductConstanst.PRODUCT_NOT_FOUND + id));
    }
}
