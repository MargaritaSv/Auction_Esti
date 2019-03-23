package org.softuni.auction_esti.domain.models.binding;

import org.softuni.auction_esti.domain.entities.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public abstract class AuctionObjectBindingModel {

    private String name;
    private BigDecimal estimateTo;
    private BigDecimal estimateFrom;
    private User estimatedBy;
    private String urlImage;

    public AuctionObjectBindingModel() {
    }

    @NotNull(message = "Name is required")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @NotNull
//    @Positive(message = "price must be positive number")
    public BigDecimal getEstimateTo() {
        return estimateTo;
    }

    public void setEstimateTo(BigDecimal estimateTo) {
        this.estimateTo = estimateTo;
    }

    //@NotNull
    //@Positive(message = "price must be positive number")
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
}
