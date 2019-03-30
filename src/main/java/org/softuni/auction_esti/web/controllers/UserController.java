package org.softuni.auction_esti.web.controllers;

//import org.softuni.auction_esti.annotations.NoCaptcha;

import org.softuni.auction_esti.domain.models.binding.UserLoginBindingModel;
import org.softuni.auction_esti.domain.models.binding.UserRegisterBindingModel;
import org.softuni.auction_esti.domain.models.sevice.UserPasswordServiceModel;
import org.softuni.auction_esti.domain.models.sevice.UserServiceModel;
import org.softuni.auction_esti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;
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
    public ModelAndView login(Map<String, Local> map, @ModelAttribute("user") UserLoginBindingModel userLoginBindingModel) {
        return super.view("login", userLoginBindingModel);
    }

    // @NoCaptcha
    @PostMapping("/login")
    public ModelAndView loginConfirm(Map<String, Local> map, ModelAndView modelAndView, @Validated @ModelAttribute("user") UserLoginBindingModel bindingModel,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            //   modelAndView.addObject("user",bindingResult);
            // redirectAttributes.addFlashAttribute("user", bindingResult);
//            redirectAttributes.addFlashAttribute("errors", bindingResult.getFieldErrors()
//                    .stream()
//                    .map(e -> e.getDefaultMessage())
//                    .collect(Collectors.toList()));

            return super.view("login", bindingModel);
        }

        UserPasswordServiceModel userFromDB = this.userService.logUser(bindingModel.getEmail());

        if (userFromDB == null || !userFromDB.getPassword().equals(bindingModel.getPassword())) {
            return super.view("/login");
        }

        return this.redirect("/");
    }

    @GetMapping("/register")
    public ModelAndView register(Map<String, Local> map, @ModelAttribute("viewModel") UserRegisterBindingModel userRegisterBindingModel) {
        return this.view("register", userRegisterBindingModel);
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(Map<String, Local> map, @Valid @ModelAttribute("viewModel") UserRegisterBindingModel bindingModel,
                                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return super.view("register", bindingModel);
        }

        if (bindingModel.getPasswordConfirm().equals(bindingModel.getPassword())) {
            this.userService.createUser(bindingModel);
            return this.redirect("/user/login");
        }

        return this.redirect("/login");
    }

    //
    @GetMapping("/logout")
    public ModelAndView login() {
        return super.redirect("/");
    }
}
