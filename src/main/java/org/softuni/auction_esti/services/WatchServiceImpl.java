package org.softuni.auction_esti.services;

import org.modelmapper.ModelMapper;
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
}
