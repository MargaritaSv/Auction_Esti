package org.softuni.auction_esti.services;

import org.modelmapper.ModelMapper;
import org.softuni.auction_esti.domain.entities.Wine;
import org.softuni.auction_esti.domain.models.sevice.WatchServiceModel;
import org.softuni.auction_esti.domain.models.sevice.WineServiceModel;
import org.softuni.auction_esti.repository.WineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WineServiceImpl implements WineService {

    private final WineRepository wineRepository;
    private final ModelMapper modelMapper;

    public WineServiceImpl(WineRepository wineRepository, ModelMapper modelMapper) {
        this.wineRepository = wineRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public WineServiceModel add(WineServiceModel wineServiceModel) {
        Wine wine = this.modelMapper.map(wineServiceModel, Wine.class);

        try {
            wine = this.wineRepository.saveAndFlush(wine);
            return this.modelMapper.map(wine, WineServiceModel.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<WineServiceModel> findAll() {
        return this.wineRepository.findAll()
                .stream()
                .map(wine -> this.modelMapper.map(wine, WineServiceModel.class))
                .collect(Collectors.toList());
    }
}
