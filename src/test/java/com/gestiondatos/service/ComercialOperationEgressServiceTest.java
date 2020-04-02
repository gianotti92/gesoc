package com.gestiondatos.service;

import com.gestiondatos.model.ComercialOperationEgress;
import com.gestiondatos.model.ComercialOperationState;
import com.gestiondatos.sampler.ComercialOperationEgressSampler;
import com.gestiondatos.validation.ComercialOperationEgressValidator;
import java.io.File;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ComercialOperationEgressServiceTest {

    private ComercialOperationEgressService comercialOperationEgressService;

    @Mock
    private ComercialOperationEgressValidator comercialOperationEgressValidator;

    private ComercialOperationEgress comercialOperationEgress;

    private BigDecimal totalCost;
    private File file;

    @BeforeEach
    public void init() {
        comercialOperationEgressService = new ComercialOperationEgressService(comercialOperationEgressValidator);
    }

    @Test
    public void calculateValueOk() {
        givenValidComercialOperationEgress();
        whenCalculateValue();
        thenTheResultWillBeOk();
    }

    @Test
    public void generateDocumentOk(){
        givenValidComercialOperationEgress();
        whenGenerateDocument();
        thenTheFileWillBeGeneratedOk();
    }

    private void givenValidComercialOperationEgress() {
        comercialOperationEgress = ComercialOperationEgressSampler.createComercialOperationEgress(ComercialOperationState.CLOSE);
    }

    private void whenCalculateValue() {
        totalCost = comercialOperationEgressService.calculateValue(comercialOperationEgress);
    }

    private void thenTheResultWillBeOk() {
        Assertions.assertEquals(new BigDecimal(25), totalCost, "The cost must be the same");
    }

    private void whenGenerateDocument() {
        file = comercialOperationEgressService.generateDocument(comercialOperationEgress);
    }

    private void thenTheFileWillBeGeneratedOk() {
        Assertions.assertNotNull(file);
    }

}
