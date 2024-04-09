package com.example.hexagonalcodebase.domain.ports.outbound;

import com.example.hexagonalcodebase.domain.model.Product;

import java.util.List;

public interface GetProductsPort {
    List<Product> getProducts();
}
