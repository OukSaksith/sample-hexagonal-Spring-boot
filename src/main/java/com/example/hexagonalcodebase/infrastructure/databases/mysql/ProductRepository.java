package com.example.hexagonalcodebase.infrastructure.databases.mysql;

import com.example.hexagonalcodebase.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsBySerialNumber(String serialNumber);
}