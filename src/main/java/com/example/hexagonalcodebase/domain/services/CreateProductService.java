package com.example.hexagonalcodebase.domain.services;

import com.example.hexagonalcodebase.common.constants.ProductConstanst;
import com.example.hexagonalcodebase.common.customannotation.UseCase;
import com.example.hexagonalcodebase.common.exception.GlobalException;
import com.example.hexagonalcodebase.common.exception.ParameterNotFoundException;
import com.example.hexagonalcodebase.domain.model.Product;
import com.example.hexagonalcodebase.domain.ports.inbound.CreateProductUseCase;
import com.example.hexagonalcodebase.domain.ports.outbound.CreateProductPort;
import com.example.hexagonalcodebase.domain.ports.outbound.ExistsProductPort;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
@UseCase
public class CreateProductService implements CreateProductUseCase {

    private CreateProductPort createProductPort;
    private ExistsProductPort existsProductPort;
    @Override
    public void createProduct(Product product) throws ParameterNotFoundException, GlobalException {
        if (StringUtils.isBlank(product.getProductName()))
            getMessageParameterNotFoundException("productName");
        if (StringUtils.isBlank(product.getProductDescription()))
            getMessageParameterNotFoundException("productDescription");
        if (product.getPrice() == null || Double.compare(product.getPrice(), ProductConstanst.D_2) <= ProductConstanst.INT)
            getMessageParameterNotFoundException("price");
        if (StringUtils.isBlank(product.getCreatedAt()))
            getMessageParameterNotFoundException("createdAt");
        if (StringUtils.isBlank(product.getSerialNumber()))
            getMessageParameterNotFoundException("serialNumber");

        if (existsProductPort.existsBySerialNumber(product.getSerialNumber()))
            throw new GlobalException(ProductConstanst.THIS_PRODUCT_IS_ALREADY_REGISTERED);

        createProductPort.createProduct(product);
    }
    private void getMessageParameterNotFoundException(String parameter) throws ParameterNotFoundException {
        throw new ParameterNotFoundException(ProductConstanst.REQUIRED_PARAMETER + "\"" + parameter + "\"" + ProductConstanst.IS_NOT_PRESENT);
    }
}
