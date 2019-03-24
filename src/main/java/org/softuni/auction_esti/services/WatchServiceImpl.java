package org.softuni.auction_esti.services;

import org.modelmapper.ModelMapper;
import org.softuni.auction_esti.domain.entities.Watch;
import org.softuni.auction_esti.domain.models.sevice.WatchServiceModel;
import org.softuni.auction_esti.repository.WatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WatchServiceImpl implements WatchService {

    private final WatchRepository watchRepository;
    private final ModelMapper modelMapper;

    public WatchServiceImpl(WatchRepository watchRepository, ModelMapper modelMapper) {
        this.watchRepository = watchRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<WatchServiceModel> findAll() {
        return this.watchRepository.findAll()
                .stream()
                .map(watch -> this.modelMapper.map(watch, WatchServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public WatchServiceModel add(WatchServiceModel watchServiceModel) {
        Watch watch = this.modelMapper.map(watchServiceModel, Watch.class);

        try {
            watch = this.watchRepository.saveAndFlush(watch);
            return this.modelMapper.map(watch, WatchServiceModel.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public WatchServiceModel findById(Integer id) {
       // return this.watchRepository.findById(id);
        return null;
    }
}
