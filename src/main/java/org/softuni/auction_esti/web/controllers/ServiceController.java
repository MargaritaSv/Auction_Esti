package org.softuni.auction_esti.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.auction_esti.domain.models.binding.*;
import org.softuni.auction_esti.domain.models.sevice.ArtServiceModel;
import org.softuni.auction_esti.domain.models.sevice.WatchServiceModel;
import org.softuni.auction_esti.domain.models.sevice.WineServiceModel;
import org.softuni.auction_esti.services.ArtService;
import org.softuni.auction_esti.services.WatchService;
import org.softuni.auction_esti.services.WineService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView watch(@ModelAttribute(name = "viewModel") WatchAddBindingModel bindingModel,
                              ModelAndView modelAndView) {
        modelAndView.addObject(bindingModel);
        modelAndView.addObject("title", null);
        modelAndView.addObject("viewName", "add_watch");
        modelAndView.setViewName("fragments/layout");
        return modelAndView;
        // return super.view("add_watch", bindingModel, "Add watch");
    }

    @PostMapping("/watch")
    public ModelAndView watchConfirm(@Valid @ModelAttribute(name = "viewModel") WatchAddBindingModel bindingModel,
                                     BindingResult bindingResult, ModelAndView modelAndView) {

        //TODO: doesnt't catch errors
        if (bindingResult.hasErrors()) {
//            modelAndView.addObject("viewName", "add_watch");
//            modelAndView.addObject("title", "Add watch");
//            modelAndView.addObject("viewModel", bindingModel);
//            modelAndView.setViewName("fragments/layout");
//
//            return modelAndView;
            return super.view("add_watch", bindingModel);
        }

        WatchServiceModel watchServiceModel = this.watchService.add(this.modelMapper.map(bindingModel, WatchServiceModel.class));
        if (watchServiceModel == null) {
            throw new IllegalArgumentException("Something went wrong!");
        }
        return this.redirect("/department/watches");
    }

    @GetMapping("/watch/edit/{id}")
    public ModelAndView editWatch(@PathVariable("id") Integer id,
                                  @ModelAttribute(name = "viewModel") WatchEditBindingModel watchEditBindingModel) {
        return super.view("edit_watch", watchEditBindingModel);
    }

    @PostMapping("/watch/edit/{id}")
    public ModelAndView editWatchConfirm(@PathVariable("id") Integer id,
                                         @ModelAttribute(name = "viewModel") WatchEditBindingModel watchEditBindingModel) {
        //da go mapna za obejct from db-to
        return super.view("edit_watch", watchEditBindingModel);
    }

    @GetMapping("/wine")
    public ModelAndView wine(@ModelAttribute(name = "viewModel") WineAddBindingModel bindingModel) {
        return super.view("add_wine", bindingModel);
    }

    @PostMapping("/wine")
    public ModelAndView wineConfirm(@Valid @ModelAttribute(name = "viewModel") WineAddBindingModel bindingModel,
                                    BindingResult bindingResult, ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {
            //  return super.view("add_wine", bindingModel);
            modelAndView.addObject("viewModel", bindingModel);
            return super.viewWithModel("add_wine","add wine", modelAndView);
        }

        WineServiceModel wineServiceModel = this.wineService.add(this.modelMapper.map(bindingModel, WineServiceModel.class));
        if (wineServiceModel == null) {
            throw new IllegalArgumentException("Something went wrong!");
        }
        return super.redirect("/department/wines");
    }

    @GetMapping("/wine/edit/{id}")
    public ModelAndView editWine(@PathVariable("id") Integer id,
                                 @ModelAttribute(name = "viewModel") WineAddBindingModel bindingModel) {
        return super.view("edit_watch", bindingModel);
    }

    @PostMapping("/wine/edit/{id}")
    public ModelAndView editWineConfirm(@PathVariable("id") Integer id,
                                        @ModelAttribute(name = "viewModel") WineAddBindingModel bindingModel,ModelAndView modelAndView) {
        //da go mapna za obejct from db-to
        modelAndView.addObject(bindingModel);
        return super.viewWithModel("edit_watch","watch" ,modelAndView);
    }

    @GetMapping("/auction")
    public ModelAndView auction(@ModelAttribute("viewoMdel") AuctionAddBindingModel bindingModel) {
        return super.view("add_auction", bindingModel);
    }

    @PostMapping("/auction")
    public ModelAndView auctionConfirm(@Valid @ModelAttribute("viewModel") AuctionAddBindingModel bindingModel,
                                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return super.view("add_auction", bindingModel);
        }

        //TODO:save
        return super.view("add_auction", bindingModel);

    }
}
