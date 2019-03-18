package org.softuni.auction_esti.domain.entities;

import org.softuni.auction_esti.domain.entities.enums.WatchCollection;

import javax.persistence.*;

@Entity
@Table(name = "watches")
public class Watch extends AuctionObject {

    private String dial;
    private String caliber;
    private String watchCase;
    private String closure;
    private Integer dimensions;
    private WatchCollection collection;

    public Watch() {
    }

    @Column(name = "dial")
    public String getDial() {
        return dial;
    }

    public void setDial(String dial) {
        this.dial = dial;
    }

    @Column(name = "caliber")
    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    @Column(name = "watch_case")
    public String getWatchCase() {
        return watchCase;
    }

    public void setWatchCase(String watchCase) {
        this.watchCase = watchCase;
    }

    @Column(name = "closure")
    public String getClosure() {
        return closure;
    }

    public void setClosure(String closure) {
        this.closure = closure;
    }

    @Column(name = "dimentions")
    public Integer getDimensions() {
        return dimensions;
    }

    public void setDimensions(Integer dimensions) {
        this.dimensions = dimensions;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "collection")
    public WatchCollection getCollection() {
        return collection;
    }

    public void setCollection(WatchCollection collection) {
        this.collection = collection;
    }
}
