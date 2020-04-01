package com.gestiondatos.model;

import java.math.BigDecimal;

public class Item {

    private final BigDecimal cost;
    private final ItemType itemType;

    public Item(BigDecimal cost, ItemType itemType) {
        this.cost = cost;
        this.itemType = itemType;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
