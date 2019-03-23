package org.softuni.auction_esti.domain.models.view;

import org.softuni.auction_esti.domain.entities.User;
import org.softuni.auction_esti.domain.entities.enums.Closure;
import org.softuni.auction_esti.domain.entities.enums.Dial;
import org.softuni.auction_esti.domain.entities.enums.WatchCollection;

import java.math.BigDecimal;

public class WatchViewModel {

    private Integer id;
    private String name;
    private BigDecimal estimateTo;
    private BigDecimal estimateFrom;
    private User estimatedBy;
    private String urlImage;
    private Dial dial;
    private String caliber;
    private String watchCase;
    private Closure closure;
    private Integer dimensions;
    private WatchCollection collection;

    public WatchViewModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getEstimateTo() {
        return estimateTo;
    }

    public void setEstimateTo(BigDecimal estimateTo) {
        this.estimateTo = estimateTo;
    }

    public BigDecimal getEstimateFrom() {
        return estimateFrom;
    }

    public void setEstimateFrom(BigDecimal estimateFrom) {
        this.estimateFrom = estimateFrom;
    }

    public User getEstimatedBy() {
        return estimatedBy;
    }

    public void setEstimatedBy(User estimatedBy) {
        this.estimatedBy = estimatedBy;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Dial getDial() {
        return dial;
    }

    public void setDial(Dial dial) {
        this.dial = dial;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getWatchCase() {
        return watchCase;
    }

    public void setWatchCase(String watchCase) {
        this.watchCase = watchCase;
    }

    public Closure getClosure() {
        return closure;
    }

    public void setClosure(Closure closure) {
        this.closure = closure;
    }

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
