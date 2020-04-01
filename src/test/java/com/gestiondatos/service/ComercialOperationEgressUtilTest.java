package com.gestiondatos.service;

import com.gestiondatos.exception.GesocException;
import com.gestiondatos.exception.GesocExceptionCode;
import com.gestiondatos.model.ComercialOperationEgress;
import com.gestiondatos.model.ComercialOperationState;
import com.gestiondatos.model.Document;
import com.gestiondatos.model.Item;
import com.gestiondatos.model.ItemType;
import com.gestiondatos.validation.ComercialOperationEgressValidator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ComercialOperationEgressUtilTest {

    private ComercialOperationEgressService comercialOperationEgressUtil;

    @Mock
    private ComercialOperationEgressValidator comercialOperationEgressValidator;

    private ComercialOperationEgress comercialOperationEgress;
    private List<Item> items;
    private Item item;
    private Document document;

    private BigDecimal totalCost;
    private GesocException gesocException;

    @BeforeEach
    public void init() {
        comercialOperationEgressUtil = new ComercialOperationEgressService(comercialOperationEgressValidator);
    }

    @Test
    public void calculateValueOk() {
        givenValidComercialOperationEgress();
        whenCalculateValue();
        thenTheResultWillBeOk();
    }

    @Test
    public void calculateValueError() {
        givenInvalidComercialOperationEgress();
        whenCalculateInvalidValue();
        thenThResultWillFaile();
    }

    private void givenValidComercialOperationEgress() {
        items = new ArrayList<>();
        item = new Item(new BigDecimal(25), ItemType.ARTICLE);
        document = new Document();
        items.add(item);
        comercialOperationEgress = new ComercialOperationEgress(items, document, ComercialOperationState.OPEN);
    }

    private void whenCalculateValue() {
        totalCost = comercialOperationEgressUtil.calculateValue(comercialOperationEgress);
    }

    private void thenTheResultWillBeOk() {
        Assertions.assertEquals(new BigDecimal(25), totalCost, "The cost must be the same");
    }

    private void givenInvalidComercialOperationEgress() {
        items = new ArrayList<>();
        item = new Item(new BigDecimal(25), ItemType.ARTICLE);
        document = new Document();
        items.add(item);
        comercialOperationEgress = new ComercialOperationEgress(items, document, ComercialOperationState.OPEN);
    }

    private void whenCalculateInvalidValue() {

        gesocException = Assertions.assertThrows(GesocException.class,
            () -> comercialOperationEgressUtil.calculateValue(comercialOperationEgress));
    }

    private void thenThResultWillFaile() {
        Assertions.assertEquals("", "", "");
    }
}
