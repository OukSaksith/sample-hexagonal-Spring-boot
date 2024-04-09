package com.example.hexagonalcodebase.infrastructure.databases.mysql;

import com.example.hexagonalcodebase.domain.ports.outbound.ExistsProductPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsProductAdapter implements ExistsProductPort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean existsBySerialNumber(String serialNumber) {
        return productRepository.existsBySerialNumber(serialNumber);
    }
}