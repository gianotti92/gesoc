package com.gestiondatos.service;

import com.gestiondatos.model.ComercialOperationEgress;
import com.gestiondatos.model.Item;
import com.gestiondatos.validation.ComercialOperationEgressValidator;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ComercialOperationEgressService {

    private final ComercialOperationEgressValidator comercialOperationEgressValidator;

    public ComercialOperationEgressService(ComercialOperationEgressValidator comercialOperationEgressValidator) {
        this.comercialOperationEgressValidator = comercialOperationEgressValidator;
    }

    public BigDecimal calculateValue(ComercialOperationEgress comercialOperationEgress) {

        comercialOperationEgressValidator.validateOpenStatus(comercialOperationEgress);

        List<BigDecimal> costs = comercialOperationEgress.getItems().stream().map(Item::getCost).collect(Collectors.toList());

        return costs.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public File generateDocument(ComercialOperationEgress comercialOperationEgress) {

        comercialOperationEgressValidator.validateItems(comercialOperationEgress);

        return new File("/test");
    }
}
