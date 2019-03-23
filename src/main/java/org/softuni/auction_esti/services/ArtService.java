package org.softuni.auction_esti.services;

import org.softuni.auction_esti.domain.models.sevice.ArtServiceModel;
import org.springframework.stereotype.Service;

public interface ArtService {
    ArtServiceModel add(ArtServiceModel artServiceModel);
}
