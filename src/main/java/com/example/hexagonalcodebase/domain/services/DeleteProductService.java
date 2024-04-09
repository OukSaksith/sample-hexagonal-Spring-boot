package com.example.hexagonalcodebase.domain.services;

import com.example.hexagonalcodebase.common.constants.ProductConstanst;
import com.example.hexagonalcodebase.common.customannotation.UseCase;
import com.example.hexagonalcodebase.common.exception.ResourceNotFoundException;
import com.example.hexagonalcodebase.domain.model.Product;
import com.example.hexagonalcodebase.domain.ports.inbound.DeleteProductUseCase;
import com.example.hexagonalcodebase.domain.ports.outbound.DeleteProductPort;
import com.example.hexagonalcodebase.domain.ports.outbound.GetProductIdPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@UseCase
public class DeleteProductService implements DeleteProductUseCase {
    private GetProductIdPort getProductIdPort;
    private DeleteProductPort deleteProductPort;

    @Override
    public void deleteProduct(Long id) throws ResourceNotFoundException {
        Product product = getProductIdPort.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ProductConstanst.PRODUCT_NOT_FOUND + id));
        deleteProductPort.deleteProduct(product);
    }
}
