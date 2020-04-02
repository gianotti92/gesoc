package com.gestiondatos.validation;

import com.gestiondatos.exception.GesocException;
import com.gestiondatos.model.ComercialOperationEgress;
import com.gestiondatos.model.ComercialOperationState;
import com.gestiondatos.model.ItemType;
import com.gestiondatos.sampler.ComercialOperationEgressSampler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ComercialOperationEgressValidatorTest {

    private ComercialOperationEgressValidator comercialOperationEgressValidator;

    private ComercialOperationEgress comercialOperation;

    private GesocException gesocException;

    @BeforeEach
    public void init() {
        comercialOperationEgressValidator = new ComercialOperationEgressValidator();
    }

    @Test
    public void validateStatusFail() {
        givenComercialOperationEgressWithStateOpen();
        whenValidateOpenStatus();
        thenTheValidatorWillThrowException();
    }

    @Test
    public void validateItemFail() {
        givenComercialOperationEgressWithOneItemAsService();
        whenValidateIfAnyItemIsService();
        thenTheValidatorWillThrowItemServiceException();
    }

    private void givenComercialOperationEgressWithStateOpen() {
        comercialOperation = ComercialOperationEgressSampler.createComercialOperationEgress(ComercialOperationState.OPEN);
    }

    private void whenValidateOpenStatus() {
        gesocException =
            Assertions.assertThrows(GesocException.class, () -> comercialOperationEgressValidator.validateOpenStatus(comercialOperation));
    }

    private void thenTheValidatorWillThrowException() {
        Assertions.assertEquals("the comercial operation egress is closed", gesocException.getGesocExceptionCode().getMessage());
    }

    private void givenComercialOperationEgressWithOneItemAsService() {
        comercialOperation = ComercialOperationEgressSampler.createComercialOperationEgress(ItemType.SERVICE);
    }

    private void whenValidateIfAnyItemIsService() {
        gesocException =
            Assertions.assertThrows(GesocException.class, () -> comercialOperationEgressValidator.validateItems(comercialOperation));
    }

    private void thenTheValidatorWillThrowItemServiceException() {
        Assertions.assertEquals("the comercial operation egress contains servicies", gesocException.getGesocExceptionCode().getMessage());
    }
}
