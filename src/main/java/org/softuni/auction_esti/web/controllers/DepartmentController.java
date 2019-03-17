package org.softuni.auction_esti.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.auction_esti.domain.models.view.WatchViewModel;
import org.softuni.auction_esti.services.WatchService;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController {

    private final WatchService watchService;
    private final ModelMapper modelMapper;

    public DepartmentController(WatchService watchService, ModelMapper modelMapper) {
        this.watchService = watchService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/canvas")
    public ModelAndView canvas(Map<String, Local> map) {
        return super.view("canvas");
    }

    @GetMapping("/watches")
    public ModelAndView watches(ModelAndView modelAndView, Map<String, Local> map) {
        List<WatchViewModel> watchViewModelList = this.watchService.findAll()
                .stream()
                .map(w -> this.modelMapper.map(w, WatchViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject(watchViewModelList);

        return super.view("watches", modelAndView);
    }


    @GetMapping("/wines")
    public ModelAndView wines(Map<String, Local> map) {
        return super.view("wines");
    }
}
