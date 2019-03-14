package org.softuni.auction_esti.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;
import java.util.Map;

@Controller
public class HomeController extends BaseController {

    @GetMapping("/")
    public ModelAndView index(Map<String, Locale> modal) {
        return super.view("index");
    }
}
