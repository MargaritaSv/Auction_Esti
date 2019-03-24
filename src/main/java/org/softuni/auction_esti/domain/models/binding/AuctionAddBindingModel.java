package org.softuni.auction_esti.domain.models.binding;

import org.softuni.auction_esti.util.validators.annotations.DateValidation;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class AuctionAddBindingModel {

    private String name;
    private String place;
    private LocalDate date;

    public AuctionAddBindingModel() {
    }

    @NotEmpty(message = "Name is required.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Place is required.")
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @DateValidation
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
