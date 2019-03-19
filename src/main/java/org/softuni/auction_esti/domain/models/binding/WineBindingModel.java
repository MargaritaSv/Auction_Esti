package org.softuni.auction_esti.domain.models.binding;

import org.softuni.auction_esti.domain.entities.enums.WineCollections;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WineBindingModel extends AuctionObjectBindingModel {

    private WineCollections collection;
    private Integer numberOfBottles;

    public WineBindingModel() {
    }

    public WineCollections getCollection() {
        return collection;
    }

    public void setCollection(WineCollections collection) {
        this.collection = collection;
    }

    @NotNull
    @Size(min = 1)
    public Integer getNumberOfBottles() {
        return numberOfBottles;
    }

    public void setNumberOfBottles(Integer numberOfBottles) {
        this.numberOfBottles = numberOfBottles;
    }
}
