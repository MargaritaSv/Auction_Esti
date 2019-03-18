package org.softuni.auction_esti.web.controllers;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {

    protected ModelAndView view(String viewName, Object viewModel, String title) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fragments/layout");
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("title", title);
        modelAndView.addObject("viewModel", viewModel);

        return modelAndView;
    }

    protected ModelAndView view(String view) {
        return this.view(view, null, null);
    }

    protected ModelAndView redirect(String url) {
        return this.view("redirect:" + url);
    }
}
