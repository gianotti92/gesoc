package com.gestiondatos.sampler;

import com.gestiondatos.model.ComercialOperationEgress;
import com.gestiondatos.model.ComercialOperationState;
import com.gestiondatos.model.Document;
import com.gestiondatos.model.Item;
import com.gestiondatos.model.ItemType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ComercialOperationEgressSampler {

    public static ComercialOperationEgress createComercialOperationEgress(ComercialOperationState comercialOperationState){

        List<Item> items = new ArrayList<>();
        Item item = new Item(new BigDecimal(25), ItemType.ARTICLE);
        Document document = new Document();
        items.add(item);
        return new ComercialOperationEgress(items, document, comercialOperationState);
    }

    public static ComercialOperationEgress createComercialOperationEgress(ItemType itemType){

        List<Item> items = new ArrayList<>();
        Item item = new Item(new BigDecimal(25), itemType);
        Document document = new Document();
        items.add(item);
        return new ComercialOperationEgress(items, document, ComercialOperationState.CLOSE);
    }
}

