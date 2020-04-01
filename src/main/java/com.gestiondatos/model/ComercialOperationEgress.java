package com.gestiondatos.model;

import java.util.List;

public class ComercialOperationEgress {

    private final List<Item> items;
    private final Document document;
    private final ComercialOperationState comercialOperationState;

    public ComercialOperationEgress(List<Item> items, Document document, ComercialOperationState comercialOperationState) {
        this.items = items;
        this.document = document;
        this.comercialOperationState = comercialOperationState;
    }

    public List<Item> getItems() {
        return items;
    }

    public Document getDocument() {
        return document;
    }

    public ComercialOperationState getComercialOperationState() {
        return comercialOperationState;
    }
}
