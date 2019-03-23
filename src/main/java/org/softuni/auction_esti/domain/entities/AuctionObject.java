package org.softuni.auction_esti.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@MappedSuperclass
public abstract class AuctionObject {

    private Integer id;
    private String name;
    private BigDecimal estimateTo;
    private BigDecimal estimateFrom;
    private User estimatedBy;
    private String urlImage;

    public AuctionObject() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    @NotNull(message = "Name is required")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "estimate_to")
    public BigDecimal getEstimateTo() {
        return estimateTo;
    }

    public void setEstimateTo(BigDecimal estimateTo) {
        this.estimateTo = estimateTo;
    }

    @NotNull(message = "Start price is required.")
    @Column(name = "estimate_from")
    public BigDecimal getEstimateFrom() {
        return estimateFrom;
    }

    public void setEstimateFrom(BigDecimal estimateFrom) {
        this.estimateFrom = estimateFrom;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "estimate_by", referencedColumnName = "id")
    public User getEstimatedBy() {
        return estimatedBy;
    }

    public void setEstimatedBy(User estimatedBy) {
        this.estimatedBy = estimatedBy;
    }

    @Column(name = "url_image")
    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

}
