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

    protected ModelAndView viewWithModel(String view,String title, ModelAndView modelAndView) {
        modelAndView.setViewName("fragments/layout");
        modelAndView.addObject("viewName", view);
          modelAndView.addObject("title", title);
       // modelAndView.addObject("viewModel", modelAndView);
        return modelAndView;
        // return this.view(view, viewModel);
    }

    protected ModelAndView view(String view, Object viewModel) {
        return this.view(view, viewModel, null);
    }

    protected ModelAndView view(String view) {
        return this.view(view, null, null);
    }

    protected ModelAndView redirect(String url) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + url);

        return modelAndView;
    }
}
