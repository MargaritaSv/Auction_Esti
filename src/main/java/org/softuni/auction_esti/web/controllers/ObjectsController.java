package org.softuni.auction_esti.web.controllers;

import org.softuni.auction_esti.annotations.NoCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/objects")
public class ObjectsController extends BaseController {

    @PostMapping("/create")
    @NoCaptcha
    public ModelAndView createObjects() {
        return this.redirect("all");
    }

    @GetMapping("/all")
    public ModelAndView allObjects() {
        //return this.stAll.Alll(),"all students listed"
        return this.redirect("all");

    }
}
