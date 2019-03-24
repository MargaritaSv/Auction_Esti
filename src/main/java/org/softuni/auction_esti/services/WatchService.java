package org.softuni.auction_esti.services;

import org.softuni.auction_esti.domain.models.sevice.WatchServiceModel;

import java.util.List;

public interface WatchService {
    List<WatchServiceModel> findAll();

    WatchServiceModel add(WatchServiceModel watchServiceModel);

    WatchServiceModel findById(Integer id);

}
