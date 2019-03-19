package org.softuni.auction_esti.domain.models.binding;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ArtBindingModel extends AuctionObjectBindingModel {

    private String author;
    private LocalDate paintedTo;
    private LocalDate paintedFrom;
    private Integer width;
    private Integer height;
    private String description;

    @NotNull
    @NotEmpty(message = "Author is required")
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

    @NotNull
    @Size(min = 5, message = "width can't be less than 50mm")
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @NotNull
    @Size(min = 5, message = "height can't be less than 50mm")
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @NotNull
    @NotEmpty(message = "description is required")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
