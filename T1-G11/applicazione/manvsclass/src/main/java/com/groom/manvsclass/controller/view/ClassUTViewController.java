package com.groom.manvsclass.controller.view;

import com.groom.manvsclass.service.JwtService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@Controller
public class ClassUTViewController {
    private final JwtService jwtService;

    public ClassUTViewController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/class")
    public ModelAndView showClass(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        if(jwtService.isJwtValid(jwt)) return new ModelAndView("class");
        return new ModelAndView("login_admin");
    }

    @GetMapping("/uploadrobots")
    public ModelAndView showUploadRobots(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        if (jwtService.isJwtValid(jwt)) return new ModelAndView("uploadRobots");
        return new ModelAndView("redirect:/loginAdmin");
    }

    @GetMapping("/modificaClasse")
    public ModelAndView showModificaClasse(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        if (jwtService.isJwtValid(jwt)) return new ModelAndView("modificaClasse");
        return new ModelAndView("redirect:/loginAdmin");
    }
}
