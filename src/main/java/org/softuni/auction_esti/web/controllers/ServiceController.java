package org.softuni.auction_esti.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/service")
public class ServiceController extends BaseController {

    @GetMapping("/art")
    public ModelAndView art() {
        return super.view("add_art");
    }

    @PostMapping("/art")
    public ModelAndView confirmArt() {
        //return this.stAll.Alll(),"all students listed"
        return super.view("add_art");

    }
}
