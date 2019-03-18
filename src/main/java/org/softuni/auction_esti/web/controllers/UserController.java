package org.softuni.auction_esti.web.controllers;

import org.softuni.auction_esti.annotations.NoCaptcha;
import org.softuni.auction_esti.domain.models.binding.UserRegisterBindingModel;
import org.softuni.auction_esti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return this.view("login");
    }

    //    @PostMapping("/login")
//    public ModelAndView login() {
//    }
//
    @GetMapping("/register")
    public ModelAndView register() {
        System.out.println("------ GET MAPPING");
        return this.view("register");
    }

    @PostMapping("/register")
    @NoCaptcha
    public ModelAndView registerConfirm(@ModelAttribute UserRegisterBindingModel userRegisterBindingModel) {

        if (userRegisterBindingModel.getPasswordConfirm().equals(userRegisterBindingModel.getPassword())) {
            this.userService.createUser(userRegisterBindingModel);
            return this.redirect("/user/login");
        }

        return this.redirect("/");
    }
//
//    @GetMapping("/logout")
//    public ModelAndView login() {
    // }
}
