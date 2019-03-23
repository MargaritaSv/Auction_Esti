package org.softuni.auction_esti.domain.models.binding;

import org.softuni.auction_esti.domain.entities.enums.WatchCollection;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WatchAddBindingModel extends AuctionObjectBindingModel {

    private String dial;
    private String caliber;
    private String watchCase;
    private String closure;
    private Integer dimensions;
    private WatchCollection collection;

    public WatchAddBindingModel() {
    }

    @NotNull(message = "Dial is required")
    @Enumerated(EnumType.STRING)
    public String getDial() {
        return dial;
    }

    public void setDial(String dial) {
        this.dial = dial;
    }

    @NotNull(message = "Caliber is required")
    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    @NotNull(message = "Watch case is required")
    public String getWatchCase() {
        return watchCase;
    }

    public void setWatchCase(String watchCase) {
        this.watchCase = watchCase;
    }

    @NotNull
    @NotEmpty(message = "Closure is required")
    @Enumerated(EnumType.STRING)
    public String getClosure() {
        return closure;
    }

    public void setClosure(String closure) {
        this.closure = closure;
    }

//    @NotNull
//    @Min(value = 10, message = "Size must be at least 10sm")
    public Integer getDimensions() {
        return dimensions;
    }

    public void setDimensions(Integer dimensions) {
        this.dimensions = dimensions;
    }

    @NotNull(message = "Collection is required")
    @Enumerated(EnumType.STRING)
    public WatchCollection getCollection() {
        return collection;
    }

    public void setCollection(WatchCollection collection) {
        this.collection = collection;
    }

}
