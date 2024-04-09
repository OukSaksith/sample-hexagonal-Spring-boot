package com.example.hexagonalcodebase.application.controller;

import com.example.hexagonalcodebase.application.response.CreateProductResponse;
import com.example.hexagonalcodebase.common.exception.GlobalException;
import com.example.hexagonalcodebase.common.exception.ParameterNotFoundException;
import com.example.hexagonalcodebase.common.exception.ResourceNotFoundException;
import com.example.hexagonalcodebase.domain.model.Product;
import com.example.hexagonalcodebase.domain.ports.inbound.CreateProductUseCase;
import com.example.hexagonalcodebase.domain.ports.inbound.DeleteProductUseCase;
import com.example.hexagonalcodebase.domain.ports.inbound.GetProductUseCase;
import com.example.hexagonalcodebase.domain.ports.inbound.GetProductsUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/products")
@AllArgsConstructor
public class ProductController {
    private final CreateProductUseCase createProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final GetProductsUseCase getProductsUseCase;
    private final GetProductUseCase getProductUseCase;

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@Valid @RequestBody Product product) throws GlobalException, ParameterNotFoundException {
        createProductUseCase.createProduct(product);
        return ResponseEntity.ok().body(CreateProductResponse.builder().id(product.getId()).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        deleteProductUseCase.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() throws ResourceNotFoundException {
        List<Product> productList = getProductsUseCase.getProducts();
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Product product = getProductUseCase.getProduct(id);
        return ResponseEntity.ok().body(product);
    }
}
