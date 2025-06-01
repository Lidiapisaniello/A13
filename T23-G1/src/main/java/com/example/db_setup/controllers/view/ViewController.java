package com.example.db_setup.controllers.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ViewController {

    @GetMapping("/register")
    public ModelAndView showRegistrationForm(HttpServletRequest request) {
        return new ModelAndView("register_new");
    }

    @GetMapping("/login_success")
    public ModelAndView showLoginSuccesForm(HttpServletRequest request) {
        return new ModelAndView("login_success");
    }

    @GetMapping("/menu")
    public ModelAndView showMenuForm(HttpServletRequest request) {
        return new ModelAndView("menu_new");
    }

    @GetMapping("/login")
    public ModelAndView showLoginForm(HttpServletRequest request) {
        return new ModelAndView("login_new");
    }

    @GetMapping("/password_reset")
    public ModelAndView showResetForm(HttpServletRequest request) {
        return new ModelAndView("password_reset_new");
    }

    @GetMapping("/password_change")
    public ModelAndView showChangeForm(HttpServletRequest request) {
        return new ModelAndView("password_change");
    }

    @GetMapping("/mail_register")
    public ModelAndView showMailForm(HttpServletRequest request) {
        return new ModelAndView("mail_register");
    }
}
