package org.softuni.auction_esti.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/private")
public class PrivateController extends BaseController {

    @GetMapping("/sell")
    public ModelAndView sell(Map<String, Locale> modal) {
        return super.view("private_sell");
    }

    @GetMapping("/buy")
    public ModelAndView buy(Map<String, Locale> modal) {
        return super.view("private_buy");
    }

    @GetMapping("/overview")
    public ModelAndView overview(Map<String, Locale> modal) {
        return super.view("overview");
    }
}
