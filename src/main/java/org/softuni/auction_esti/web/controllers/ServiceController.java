package org.softuni.auction_esti.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.auction_esti.domain.models.binding.ArtAddBindingModel;
import org.softuni.auction_esti.domain.models.binding.WatchAddBindingModel;
import org.softuni.auction_esti.domain.models.binding.WineAddBindingModel;
import org.softuni.auction_esti.domain.models.sevice.ArtServiceModel;
import org.softuni.auction_esti.domain.models.sevice.WatchServiceModel;
import org.softuni.auction_esti.domain.models.sevice.WineServiceModel;
import org.softuni.auction_esti.services.ArtService;
import org.softuni.auction_esti.services.WatchService;
import org.softuni.auction_esti.services.WineService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ServiceController extends BaseController {

    private final WatchService watchService;
    private final ArtService artService;
    private final WineService wineService;
    private final ModelMapper modelMapper;

    public ServiceController(WatchService watchService, ArtService artService, WineService wineService, ModelMapper modelMapper) {
        this.watchService = watchService;
        this.artService = artService;
        this.wineService = wineService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/art")
    public ModelAndView art(@ModelAttribute(name = "viewModel") ArtAddBindingModel bindingModel) {
        return super.view("add_art", bindingModel);
    }

    @PostMapping("/art")
    public ModelAndView confirmArt(@Valid @ModelAttribute(name = "viewModel") ArtAddBindingModel bindingModel,
                                   BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return super.view("add_art", bindingModel);
        }

        ArtServiceModel artServiceModel = this.artService.add(this.modelMapper.map(bindingModel, ArtServiceModel.class));
        if (artServiceModel == null) {
            throw new IllegalArgumentException("Something went wrong!");
        }
        return super.redirect("/department/art");

    }

    @GetMapping("/watch")
    public ModelAndView watch(@ModelAttribute(name = "viewModel") WatchAddBindingModel bindingModel) {
        return super.view("add_watch", bindingModel);
    }

    @PostMapping("/watch")
    public ModelAndView watchConfirm(@Valid @ModelAttribute(name = "viewModel") WatchAddBindingModel bindingModel,
                                     BindingResult bindingResult) {

        //TODO: doesnt't catch errors
        if (bindingResult.hasErrors()) {
            return super.view("add_watch", bindingModel);
        }

        WatchServiceModel watchServiceModel = this.watchService.add(this.modelMapper.map(bindingModel, WatchServiceModel.class));
        if (watchServiceModel == null) {
            throw new IllegalArgumentException("Something went wrong!");
        }
        return this.redirect("/department/watches");
    }

    @GetMapping("/wine")
    public ModelAndView wine(@ModelAttribute(name = "viewModel") WineAddBindingModel bindingModel) {
        return super.view("add_wine", bindingModel);
    }

    @PostMapping("/wine")
    public ModelAndView confirmWine(@Valid @ModelAttribute(name = "viewModel") WineAddBindingModel bindingModel,
                                    BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return super.view("add_wine", bindingModel);
        }

        WineServiceModel wineServiceModel = this.wineService.add(this.modelMapper.map(bindingModel, WineServiceModel.class));
        if (wineServiceModel == null) {
            throw new IllegalArgumentException("Something went wrong!");
        }
        return super.redirect("/department/wine");

    }
}
