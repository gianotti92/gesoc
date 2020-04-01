package com.gestiondatos.validation;

import com.gestiondatos.exception.GesocException;
import com.gestiondatos.exception.GesocExceptionCode;
import com.gestiondatos.model.ComercialOperationEgress;
import com.gestiondatos.model.ComercialOperationState;
import com.gestiondatos.model.ItemType;

public class ComercialOperationEgressValidator {

    public void validateOpenStatus(ComercialOperationEgress comercialOperation){

        if(isComercialOperationOpen(comercialOperation)){
            throw new GesocException(GesocExceptionCode.CLOSE_COMERCIAL_OPERATION_EGRESS_CLOSE);
        }
    }

    public void validateItems(ComercialOperationEgress comercialOperationEgress){
        if(isAnyItemsIsService(comercialOperationEgress)){
            throw new GesocException(GesocExceptionCode.CLOSE_COMERCIAL_OPERATION_ENTRY_WITH_SERVICE);
        }
    }

    private Boolean isComercialOperationOpen(ComercialOperationEgress comercialOperationEgress){

        return comercialOperationEgress.getComercialOperationState().equals(ComercialOperationState.OPEN);
    }

    private boolean isAnyItemsIsService(ComercialOperationEgress comercialOperationEgress) {
        return comercialOperationEgress.getItems().stream().anyMatch(item -> item.getItemType().equals(ItemType.SERVICE));
    }
}
