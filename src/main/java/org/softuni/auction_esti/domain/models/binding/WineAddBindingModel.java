package org.softuni.auction_esti.domain.models.binding;

import org.softuni.auction_esti.domain.entities.enums.WineCollections;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WineAddBindingModel extends AuctionObjectBindingModel {

    private WineCollections collection;
    private Integer numberOfBottles;

    public WineAddBindingModel() {
    }

    @NotNull
  //  @NotEmpty(message = "Collection is required")
    @Enumerated(EnumType.STRING)
    public WineCollections getCollection() {
        return collection;
    }

    public void setCollection(WineCollections collection) {
        this.collection = collection;
    }

    @NotNull
    @Min(value = 1, message = "required")
    public Integer getNumberOfBottles() {
        return numberOfBottles;
    }

    public void setNumberOfBottles(Integer numberOfBottles) {
        this.numberOfBottles = numberOfBottles;
    }
}
