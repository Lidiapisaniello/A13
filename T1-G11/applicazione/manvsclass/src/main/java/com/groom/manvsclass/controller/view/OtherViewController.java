package com.groom.manvsclass.controller.view;

import com.groom.manvsclass.service.AchievementService;
import com.groom.manvsclass.service.JwtService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@Controller
public class OtherViewController {

    private final JwtService jwtService;
    private final AchievementService achievementService;

    public OtherViewController(JwtService jwtService, AchievementService achievementService) {
        this.jwtService = jwtService;
        this.achievementService = achievementService;
    }

    /*
    *   Non esiste la pagina gestione_assignments.html
    public ModelAndView showGestioneAssignments(HttpServletRequest request, String jwt) {
        if (jwtService.isJwtValid(jwt)) {return new ModelAndView("gestione_assignments");}
        return new ModelAndView("redirect:/loginAdmin");
    }

     */

    @GetMapping("/reportClasse")
    public ModelAndView showReportClasse(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        if (jwtService.isJwtValid(jwt)) return new ModelAndView("reportClasse");
        return new ModelAndView("redirect:/loginAdmin");
    }

    @GetMapping("/Reports")
    public ModelAndView showReports(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        if (jwtService.isJwtValid(jwt)) return new ModelAndView("Reports");
        return new ModelAndView("redirect:/loginAdmin");
    }





}
