package org.softuni.auction_esti.web.controllers;

import org.softuni.auction_esti.annotations.NoCaptcha;
import org.softuni.auction_esti.domain.models.binding.UserLoginBindingModel;
import org.softuni.auction_esti.domain.models.binding.UserRegisterBindingModel;
import org.softuni.auction_esti.domain.models.sevice.UserPasswordServiceModel;
import org.softuni.auction_esti.domain.models.sevice.UserServiceModel;
import org.softuni.auction_esti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.stream.Collectors;

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

    @NoCaptcha
    @PostMapping("/login")
    public ModelAndView loginConfirm(@Valid @ModelAttribute("user") UserLoginBindingModel userLoginBindingModel,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("model", bindingResult);
            redirectAttributes.addFlashAttribute("errors", bindingResult.getFieldErrors()
                    .stream()
                    .map(e -> e.getDefaultMessage())
                    .collect(Collectors.toList()));

            return super.redirect("/user/login");
        }

        UserPasswordServiceModel userFromDB = this.userService.logUser(userLoginBindingModel.getNickname());

        if (userFromDB == null || !userFromDB.getPassword().equals(userLoginBindingModel.getPassword())) {
            return this.view("/user/login");
        }

        return this.redirect("/");
    }

    @GetMapping("/register")
    public ModelAndView register() {
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
