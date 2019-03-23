package org.softuni.auction_esti.services;

import org.modelmapper.ModelMapper;
import org.softuni.auction_esti.domain.entities.Art;
import org.softuni.auction_esti.domain.models.sevice.ArtServiceModel;
import org.softuni.auction_esti.repository.ArtRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtServiceImpl implements ArtService {
    private final ArtRepository artRepository;
    private final ModelMapper modelMapper;

    public ArtServiceImpl(ArtRepository artRepository, ModelMapper modelMapper) {
        this.artRepository = artRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ArtServiceModel add(ArtServiceModel artServiceModel) {
        Art art = this.modelMapper.map(artServiceModel, Art.class);

        try {
            art = this.artRepository.saveAndFlush(art);
            return this.modelMapper.map(art, ArtServiceModel.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
