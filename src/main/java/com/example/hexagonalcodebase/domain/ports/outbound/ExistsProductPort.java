package com.example.hexagonalcodebase.domain.ports.outbound;

public interface ExistsProductPort {
    boolean existsBySerialNumber(String serialNumber);
}
