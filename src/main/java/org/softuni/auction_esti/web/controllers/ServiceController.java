package org.softuni.auction_esti.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.auction_esti.domain.models.binding.WatchAddBindingModel;
import org.softuni.auction_esti.domain.models.sevice.WatchServiceModel;
import org.softuni.auction_esti.services.WatchService;
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
    private final ModelMapper modelMapper;

    public ServiceController(WatchService watchService, ModelMapper modelMapper) {
        this.watchService = watchService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/art")
    public ModelAndView art() {
        return super.view("add_art");
    }

    @PostMapping("/art")
    public ModelAndView confirmArt() {
        //return this.stAll.Alll(),"all students listed"
        return super.view("add_art");

    }

    @GetMapping("/watch")
    public ModelAndView watch(@ModelAttribute(name = "viewModel") WatchAddBindingModel bindingModel) {
        return super.view("add_watch", bindingModel);
    }

    @PostMapping("/watch")
    public ModelAndView watchConfirm(@Valid @ModelAttribute(name = "viewModel") WatchAddBindingModel bindingModel,
                                     BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return super.view("add_watch", bindingModel);
        }

        WatchServiceModel watchServiceModel = this.watchService.add(this.modelMapper.map(bindingModel, WatchServiceModel.class));
        if (watchServiceModel == null) {
            throw new IllegalArgumentException("Something went wrong!");
        }
        return super.redirect("watches");


    }
}
