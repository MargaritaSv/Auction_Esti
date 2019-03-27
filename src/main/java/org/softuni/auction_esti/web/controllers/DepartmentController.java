package org.softuni.auction_esti.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.auction_esti.domain.models.binding.WatchShowBindingModel;
import org.softuni.auction_esti.domain.models.binding.WineShowBindingModel;
import org.softuni.auction_esti.domain.models.view.WatchViewModel;
import org.softuni.auction_esti.domain.models.view.WineViewModel;
import org.softuni.auction_esti.services.WatchService;
import org.softuni.auction_esti.services.WineService;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController {

    private final WatchService watchService;
    private final WineService wineService;
    private final ModelMapper modelMapper;

    public DepartmentController(WatchService watchService, WineService wineService, ModelMapper modelMapper) {
        this.watchService = watchService;
        this.wineService = wineService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/art")
    public ModelAndView canvas(Map<String, Local> map) {
        return super.view("canvas");
    }

    @GetMapping("/watches")
    public ModelAndView watches(Map<String, Local> map,
                                @ModelAttribute(name = "bindingModel") WatchShowBindingModel bindingModel) {
        List<WatchViewModel> watchViewModelList = this.watchService.findAll()
                .stream()
                .map(w -> this.modelMapper.map(w, WatchViewModel.class))
                .collect(Collectors.toList());

        //   modelAndView.addObject("watches", watchViewModelList);

        return super.view("watches", watchViewModelList, null);
    }


    @GetMapping("/wines")
    public ModelAndView wines(Map<String, Local> map, @ModelAttribute(name = "bindingModel") WineShowBindingModel bindingModel) {
        List<WineViewModel> wineViewModelList = this.wineService.findAll()
                .stream()
                .map(wine -> this.modelMapper.map(wine, WineViewModel.class))
                .collect(Collectors.toList());

        return super.view("wines", wineViewModelList, "wines");
    }
}
