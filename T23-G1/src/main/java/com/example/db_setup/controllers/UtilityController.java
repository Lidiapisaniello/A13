package com.example.db_setup.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;


@RestController
@CrossOrigin
public class UtilityController {

    @PostMapping("/changeLanguage")
    public String changeLanguage(HttpServletRequest request, @RequestParam("lang") String lang, RedirectAttributes redirectAttributes) {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (localeResolver != null) {
            localeResolver.setLocale(request, null, Locale.forLanguageTag(lang));
        }

        // Redirect back to the referring page, or to a default page
        String referer = request.getHeader("Referer");
        return "redirect:" + (referer != null ? referer : "/");
    }


}
