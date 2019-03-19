package org.softuni.auction_esti.web.controllers;

//import org.softuni.auction_esti.annotations.NoCaptcha;
import org.softuni.auction_esti.domain.models.binding.UserLoginBindingModel;
import org.softuni.auction_esti.domain.models.binding.UserRegisterBindingModel;
import org.softuni.auction_esti.domain.models.sevice.UserPasswordServiceModel;
import org.softuni.auction_esti.domain.models.sevice.UserServiceModel;
import org.softuni.auction_esti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView login(@ModelAttribute("user") UserLoginBindingModel userLoginBindingModel) {
        return this.view("login");
    }

   // @NoCaptcha
    @PostMapping("/login")
    public ModelAndView loginConfirm(ModelAndView modelAndView, @Validated @ModelAttribute("user") UserLoginBindingModel userLoginBindingModel,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            //   modelAndView.addObject("user",bindingResult);
            // redirectAttributes.addFlashAttribute("user", bindingResult);
//            redirectAttributes.addFlashAttribute("errors", bindingResult.getFieldErrors()
//                    .stream()
//                    .map(e -> e.getDefaultMessage())
//                    .collect(Collectors.toList()));

            return super.view("login", userLoginBindingModel);
        }

        UserPasswordServiceModel userFromDB = this.userService.logUser(userLoginBindingModel.getNickname());

        if (userFromDB == null || !userFromDB.getPassword().equals(userLoginBindingModel.getPassword())) {
            return this.view("/user/login");
        }

        return this.redirect("/");
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute( "viewModel") UserRegisterBindingModel userRegisterBindingModel) {
        return this.view("register",userRegisterBindingModel);
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@Valid @ModelAttribute("viewModel") UserRegisterBindingModel userRegisterBindingModel,
                                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return super.view("register", userRegisterBindingModel);
        }

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
