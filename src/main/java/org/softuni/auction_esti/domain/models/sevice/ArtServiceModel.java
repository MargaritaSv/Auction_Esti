package org.softuni.auction_esti.domain.models.sevice;

import org.softuni.auction_esti.domain.entities.UserDetails;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ArtServiceModel {

    private Integer id;
    private String name;
    private BigDecimal estimateTo;
    private BigDecimal estimateFrom;
    private UserDetails estimatedBy;
    private String urlImage;
    private String author;
    private LocalDate paintedTo;
    private LocalDate paintedFrom;
    private Integer width;
    private Integer height;
    private String description;

    public ArtServiceModel() {
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

    public UserDetails getEstimatedBy() {
        return estimatedBy;
    }

    public void setEstimatedBy(UserDetails estimatedBy) {
        this.estimatedBy = estimatedBy;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPaintedTo() {
        return paintedTo;
    }

    public void setPaintedTo(LocalDate paintedTo) {
        this.paintedTo = paintedTo;
    }

    public LocalDate getPaintedFrom() {
        return paintedFrom;
    }

    public void setPaintedFrom(LocalDate paintedFrom) {
        this.paintedFrom = paintedFrom;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
