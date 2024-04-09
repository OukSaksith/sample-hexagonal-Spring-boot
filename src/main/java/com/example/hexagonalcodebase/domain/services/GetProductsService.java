package com.example.hexagonalcodebase.domain.services;

import com.example.hexagonalcodebase.common.constants.ProductConstanst;
import com.example.hexagonalcodebase.common.customannotation.UseCase;
import com.example.hexagonalcodebase.common.exception.ResourceNotFoundException;
import com.example.hexagonalcodebase.domain.model.Product;
import com.example.hexagonalcodebase.domain.ports.inbound.GetProductsUseCase;
import com.example.hexagonalcodebase.domain.ports.outbound.GetProductsPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@UseCase
public class GetProductsService implements GetProductsUseCase {

    private GetProductsPort getProductsPort;

    @Override
    public List<Product> getProducts() throws ResourceNotFoundException {

        List<Product> productList = getProductsPort.getProducts();
        if (productList.isEmpty())
            throw new ResourceNotFoundException(ProductConstanst.PRODUCTS_NOT_FOUND);

        return productList;
    }
}