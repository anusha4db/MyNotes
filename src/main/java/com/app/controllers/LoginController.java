package com.app.controllers;

import com.app.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class LoginController {


    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("LoginForm", new LoginForm());

        return "login";
    }

    @PostMapping(value = "/login")
    public String loginInfo(@ModelAttribute("LoginForm") @Valid LoginForm loginForm,
                            BindingResult result) {

        if (!result.hasErrors()) {
            return "register";
        }


        return "login";
    }

    @RequestMapping("/loginError")
    public String loginError(@ModelAttribute("LoginForm") @Valid LoginForm loginForm, Model model) {

        model.addAttribute("loginError", true);
        return "login.html";
    }
}
