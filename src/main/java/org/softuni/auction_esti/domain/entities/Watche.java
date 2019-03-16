package org.softuni.auction_esti.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "watches")
public class Watche extends AuctionObject {

    private String dial;
    private String caliber;
    private String watcheCase;
    private String closure;
    private Integer dimensions;
    private WatcheCollection collection;

    public Watche() {
    }

    public String getDial() {
        return dial;
    }

    public void setDial(String dial) {
        this.dial = dial;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getWatcheCase() {
        return watcheCase;
    }

    public void setWatcheCase(String watcheCase) {
        this.watcheCase = watcheCase;
    }

    public String getClosure() {
        return closure;
    }

    public void setClosure(String closure) {
        this.closure = closure;
    }

    public Integer getDimensions() {
        return dimensions;
    }

    public void setDimensions(Integer dimensions) {
        this.dimensions = dimensions;
    }

    public WatcheCollection getCollection() {
        return collection;
    }

    public void setCollection(WatcheCollection collection) {
        this.collection = collection;
    }
}
