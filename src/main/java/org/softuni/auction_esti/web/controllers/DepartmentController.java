package org.softuni.auction_esti.web.controllers;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController {

    @GetMapping("/canvas")
    public ModelAndView canvas(Map<String, Local> map) {
        return super.view("canvas");
    }

    @GetMapping("/watches")
    public ModelAndView watches(Map<String, Local> map) {
        return super.view("watches");
    }

    @GetMapping("/wines")
    public ModelAndView wines(Map<String, Local> map) {
        return super.view("wines");
    }
}
