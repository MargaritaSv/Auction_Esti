package org.softuni.auction_esti.domain.models.binding;

import org.softuni.auction_esti.domain.entities.enums.WineCollections;

public class WineShowBindingModel extends AuctionObjectBindingModel {

    private WineCollections collection;
    private Integer numberOfBottles;

    public WineShowBindingModel() {
    }

    public WineCollections getCollection() {
        return collection;
    }

    public void setCollection(WineCollections collection) {
        this.collection = collection;
    }

    public Integer getNumberOfBottles() {
        return numberOfBottles;
    }

    public void setNumberOfBottles(Integer numberOfBottles) {
        this.numberOfBottles = numberOfBottles;
    }
}
