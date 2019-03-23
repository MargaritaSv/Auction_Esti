package org.softuni.auction_esti.domain.models.binding;

import org.softuni.auction_esti.domain.entities.enums.WatchCollection;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class WatchShowBindingModel extends AuctionObjectBindingModel {

    private String dial;
    private String caliber;
    private String watchCase;
    private String closure;
    private Integer dimensions;
    private WatchCollection collection;

    @NotNull
    @NotEmpty(message = "Dial is required")
    public String getDial() {
        return dial;
    }

    public void setDial(String dial) {
        this.dial = dial;
    }

    @NotNull
    @NotEmpty(message = "Caliber is required")
    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    @NotNull
    @NotEmpty(message = "Watch case is required")
    public String getWatchCase() {
        return watchCase;
    }

    public void setWatchCase(String watchCase) {
        this.watchCase = watchCase;
    }

    @NotNull
    @NotEmpty(message = "Closure is required")
    public String getClosure() {
        return closure;
    }

    public void setClosure(String closure) {
        this.closure = closure;
    }

    @NotNull
    @Size(min = 10, max = 35)
    public Integer getDimensions() {
        return dimensions;
    }

    public void setDimensions(Integer dimensions) {
        this.dimensions = dimensions;
    }

    public WatchCollection getCollection() {
        return collection;
    }

    public void setCollection(WatchCollection collection) {
        this.collection = collection;
    }
}
