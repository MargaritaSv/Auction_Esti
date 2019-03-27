package org.softuni.auction_esti.services;

import org.softuni.auction_esti.domain.models.sevice.WineServiceModel;

import java.util.List;

public interface WineService {

    WineServiceModel add(WineServiceModel wineServiceModel);

    List<WineServiceModel> findAll();
}
