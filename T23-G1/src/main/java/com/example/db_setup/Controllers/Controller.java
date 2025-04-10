/*
 *   Copyright (c) 2025 Stefano Marano https://github.com/StefanoMarano80017
 *   All rights reserved.

 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at

 *   http://www.apache.org/licenses/LICENSE-2.0

 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.example.db_setup.Controllers;

import com.example.db_setup.Service.RegistrationService;
import com.example.db_setup.model.*;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.db_setup.EmailService;
import com.example.db_setup.MyPasswordEncoder;
import com.example.db_setup.MyResponseClass;
import com.example.db_setup.UserRepository;
import com.example.db_setup.Authentication.AuthenticatedUser;
import com.example.db_setup.Authentication.AuthenticatedUserRepository;
import com.example.db_setup.Service.OAuthUserGoogleService;
import com.example.db_setup.Service.UserService;
import com.example.db_setup.model.Studies;
import com.example.db_setup.model.User;
//MODIFICA (Deserializzazione risposta JSON)
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUserRepository authenticatedUserRepository;

    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Autowired
    private EmailService emailService;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    //MODIFICA (10/2/2024) : gestione dei token di accesso
    private String app_token = "689086720098849|_rIns2JmCHSjLbj2in8O7M9CAWw";
    //FINE MODIFICA


    //String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{3,14}$"; // maiuscola, minuscola e numero

    //REGEX -- Modifica (03/02/2024) : La psw deve contenere da 8 a 16 caratteri, di cui almeno un carattere minuscolo,
    //                                 maiuscolo, un numero ed un carattere speciale
    String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,16}$"; // maiuscola, minuscola, numero e chr. speciale
    Pattern p = Pattern.compile(regex);

    private final RegistrationService registrationService;

    public Controller(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    //Modifica 04/12/2024 Giuleppe: Aggiunta rotta
    @PostMapping("/studentsByIds")
    public ResponseEntity<?> getStudentsByIds(@RequestBody List<String> idsStudenti){
        return userService.getStudentsByIds(idsStudenti);
    }

    //Modifica 06/12/2024 Giuleppe: Aggiunta rotta
    @GetMapping("/studentByEmail/{emailStudente}")
    @ResponseBody
    public ResponseEntity<?> getStudentByEmail(@PathVariable("emailStudente") String emailStudent){
        return userService.getStudentByEmail(emailStudent);
    }

    //Modifica 12/12/2024
    @GetMapping("/studentsByNameSurname")
    @ResponseBody
    public List<Map<String,Object>> getStudentsBySurnameAndName(@RequestBody Map<String, String> request){
        return userService.getStudentsBySurnameAndName(request);
    }
    
    //Modifica 12/12/2024 Giuleppe: Aggiunta nuova rotta che verrà aggiunta per la ricerca degli studenti. 
    @PostMapping("/searchStudents")
    @ResponseBody
    public List<Map<String,Object>> searchStudents(@RequestBody Map<String, String> request){
        return userService.searchStudents(request);
    }

    // Registrazione
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam("name") String name,
                                            @RequestParam("surname") String surname,
                                            @RequestParam("email") String email,
                                            @RequestParam("password") String password,
                                            @RequestParam("check_password") String check_password,
                                            @RequestParam("studies") Studies studies, @CookieValue(name = "jwt", required = false) String jwt, HttpServletRequest request) {

        if(isJwtValid(jwt)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Already logged in");
        }

        User n = new User();

        // NOME -- Modifica (02/02/2024) : Possibilità di inserire più nomi separati da uno spazio
        // regex_old = "[a-zA-Z]+" , regex_new = "[a-zA-Z]+(\s[a-zA-Z]+)*"
        //if ((name.length() >= 2) && (name.length() <= 30) && (Pattern.matches("[a-zA-Z]+", name))) {
        if ((name.length() >= 2) && (name.length() <= 30) && (Pattern.matches("[a-zA-Z]+(\\s[a-zA-Z]+)*", name))) {
            n.setName(name);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name not valid");
        }

        // COGNOME --Modifica (02/02/2024) : Possibilità di inserire più parole separate da uno spazio ed eventualmente
        //                                  da un apostrofo
        // regex_old = "[a-zA-Z]+" , regex_new = [a-zA-Z]+(\s?[a-zA-Z]+\'?)*
        //if ((name.length() >= 2) && (surname.length() <= 30) && (Pattern.matches("[a-zA-Z]+", surname))) {
        if ((name.length() >= 2) && (surname.length() <= 30) && (Pattern.matches("[a-zA-Z]+(\\s?[a-zA-Z]+\\'?)*", surname))) {
            n.setSurname(surname);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Surname not valid");
        }

        // EMAIL
        if ((email.contains("@")) && (email.contains("."))) {
            User user = userRepository.findByUserProfileEmail(email);
            if (user != null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utente con questa email già registrato");
            }
            n.setEmail(email);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email not valid");
        }

        // PASSWORD
        Matcher m = p.matcher(password);

        if ((password.length() >16) || (password.length() < 8) || !(m.matches())) {
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password not valid, maiuscola, minuscola e numero, con lunghezza tra 8 e 16");
            //MODIFICA (05/02/2024)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password non valida! La password deve contenere almeno una lettera maiuscola, una minuscola, un numero ed un carattere speciale e deve essere lunga tra gli 8 e i 16 caratteri");
            //FINE MODIFICA
        }

        if (password.equals(check_password)) {
            String crypted = myPasswordEncoder.encoder().encode(password);
            n.setPassword(crypted);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check_Password not valid");
        }

        // STUDIES
        n.setStudies(studies);

        userRepository.save(n);
        Integer ID = n.getID();

        // Richiedo l'inizializzazione deli punti esperienza per il nuovo utente. Se la richiesta fallisce, elimino
        // l'utente e restituisco un messaggio di errore
        if (!registrationService.initializeExperiencePoints(ID)) {
            userRepository.delete(n);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error initializing experience points. Please retry to subscribe.");
        }

        /*
         * Il mancato invio della mail di conferma non è più bloccante per il redirect.
         * L'utente viene registrato prima dell'invio della mail di avvenuta registrazione. Non ha senso che il mancato
         * invio impedisca il redirect e restituisca un errore di registrazione. Inoltre Gmail prevede un numero max di
         * mail inviate per giorno, superato il limite Get /login restituirebbe sempre errore.
         */
        try {
            emailService.sendMailRegister(email, ID);
        } catch (MessagingException e) {
            System.out.println("[POST /register] Errore nell'invio della mail di conferma registrazione: " + e.getMessage());
            // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to confirm your registration");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/login_success");
        return new ResponseEntity<String>(headers,HttpStatus.MOVED_PERMANENTLY);

    }

    // Autenticazione
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("email") String email,
                                        @RequestParam("password") String password, @CookieValue(name = "jwt", required = false) String jwt, HttpServletRequest request, HttpServletResponse response) {

        if(isJwtValid(jwt)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Already logged in");
        }

        User user = userRepository.findByUserProfileEmail(email);
        
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email not found");
        } else if (user.isRegisteredWithFacebook) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User already registered with facebook, please log in with facebook");
        }

        System.out.println("Utente registrato, email trovata nel database (login)");
        boolean passwordMatches = myPasswordEncoder.matches(password, user.password);
        if (!passwordMatches) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
        }

        String token = generateToken(user);
        AuthenticatedUser authenticatedUser = new AuthenticatedUser(user, token);
        authenticatedUserRepository.save(authenticatedUser);
        System.out.println("authenticatedUser creato (login)");

        Cookie jwtTokenCookie = new Cookie("jwt", token);
        jwtTokenCookie.setMaxAge(3600);
        response.addCookie(jwtTokenCookie);
        System.out.println("Cookie aggiunto alla risposta (login)");
        System.out.println("token_received:"+token);

        try {
            response.sendRedirect("/main");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(302).body("");
    }

    public static String generateToken(User user) {
        Instant now = Instant.now();
        Instant expiration = now.plus(1, ChronoUnit.HOURS);

        String token = Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(expiration))
                .claim("userId", user.getID())
                .claim("role", "user")
                .signWith(SignatureAlgorithm.HS256, "mySecretKey")
                .compact();

        return token;
    }

    // Logout
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletResponse response) {
        System.out.println("-----------------LOGOUT------------------");
        Cookie jwtTokenCookie = new Cookie("jwt", null);
        jwtTokenCookie.setMaxAge(0);
        response.addCookie(jwtTokenCookie);
        System.out.println("GET logout called, token removed");
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam("authToken") String authToken, HttpServletResponse response, HttpServletRequest request) {
        AuthenticatedUser authenticatedUser = authenticatedUserRepository.findByAuthToken(authToken);
        System.out.println("POST logout called, token removed");

        if (authenticatedUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }

        Cookie jwtTokenCookie = new Cookie("jwt", null);
        jwtTokenCookie.setMaxAge(0);
        response.addCookie(jwtTokenCookie);

        // Delete JSESSIONID cookie
        Cookie jsessionidCookie = new Cookie("JSESSIONID", null);
        jsessionidCookie.setMaxAge(0);
        response.addCookie(jsessionidCookie);

        authenticatedUserRepository.delete(authenticatedUser);
        //Modifica 18/05/2024: Cancellazione dei cookie e del contesto di autenticazione di spring
        SecurityContextHolder.clearContext();
        HttpSession session= request.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        return ResponseEntity.ok("Logout successful");
    }

    //Recupera Password
    @PostMapping("/password_reset")
    public ResponseEntity<String> resetPassword(@RequestParam("email") String email, @CookieValue(name = "jwt", required = false) String jwt, HttpServletRequest request) {
        if(isJwtValid(jwt)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Already logged in");
        }

        User user = userRepository.findByUserProfileEmail(email);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email not found");
        }

        String resetToken = generateToken(user);
        user.setResetToken(resetToken);
        userRepository.save(user);

        try {
            emailService.sendPasswordResetEmail(email, resetToken);
            return ResponseEntity.ok("Password reset email sent successfully");
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send password reset email");
        }

    }

    @PostMapping("/password_change")
    public ResponseEntity<String> changePassword(@RequestParam("email") String email,
                                                @RequestParam("token") String resetToken,
                                                @RequestParam("newPassword") String newPassword,
                                                @RequestParam("confirmPassword") String confirmPassword, @CookieValue(name = "jwt", required = false) String jwt, HttpServletRequest request) {

        if(isJwtValid(jwt)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Already logged in");
        }

        User user = userRepository.findByUserProfileEmail(email);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email not found");
        }

        if (!resetToken.equals(user.getResetToken())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid reset token");
        }

        Matcher m = p.matcher(newPassword);

        if ((newPassword.length() >= 15) || (newPassword.length() <= 2) || !(m.matches())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password not valid");
        }

        if (newPassword.equals(confirmPassword)) {
            String cryptedPassword = myPasswordEncoder.encoder().encode(newPassword);
            user.setPassword(cryptedPassword);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check_Password not valid");
        }

        user.setResetToken(null);
        userRepository.save(user);

        return ResponseEntity.ok("Password change successful");
    }

    public boolean isJwtValid(String jwt) {
        try {
            Claims c = Jwts.parser().setSigningKey("mySecretKey").parseClaimsJws(jwt).getBody();

            if((new Date()).before(c.getExpiration())) {
                return true;
            }
        } catch(Exception e) {
            System.err.println(e);
        }

        return false;
    }

    @PostMapping("/validateToken")
    public ResponseEntity<Boolean> checkValidityToken( @RequestParam("jwt") String jwt) {
        if(isJwtValid(jwt)) return ResponseEntity.ok(true);
        return ResponseEntity.ok(false);
    }

    @GetMapping("/register")
    public ModelAndView showRegistrationForm(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        if(isJwtValid(jwt)) return new ModelAndView("redirect:/main");
        return new ModelAndView("register_new");
    }

    //MODIFICA (03/02/2024) : Feedback registrazione avvenuta con successo + redirect alla pagina di /login
    @GetMapping("/login_success")
    public ModelAndView showLoginSuccesForm(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        if(isJwtValid(jwt)) return new ModelAndView("redirect:/main");
        return new ModelAndView("login_success");
    }

    @GetMapping("/menu")
    public ModelAndView showMenuForm(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        System.out.println("GET (/menu)");
        if(isJwtValid(jwt)) return new ModelAndView("redirect:/login");
        return new ModelAndView("menu_new");
    }

    @GetMapping("/login")
    public ModelAndView showLoginForm(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        if(isJwtValid(jwt)) return new ModelAndView("redirect:/main");

        return new ModelAndView("login_new");
    }

    @GetMapping("/students_list")
    public List<User> getAllStudents() {
        return userRepository.findAll();
    }

    @GetMapping("/students_list/{ID}")
    @ResponseBody
    public User getStudent(@PathVariable String ID) {
        return userRepository.findByID(Integer.parseInt(ID));
    }

    @GetMapping("/password_reset")
    public ModelAndView showResetForm(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        if(isJwtValid(jwt)) return new ModelAndView("redirect:/main");
        return new ModelAndView("password_reset_new");
    }

    @GetMapping("/password_change")
    public ModelAndView showChangeForm(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        if(isJwtValid(jwt)) return new ModelAndView("redirect:/main");
        return new ModelAndView("password_change");
    }

    @GetMapping("/mail_register")
    public ModelAndView showMailForm(HttpServletRequest request, @CookieValue(name = "jwt", required = false) String jwt) {
        if(isJwtValid(jwt)) return new ModelAndView("redirect:/main");
        return new ModelAndView("mail_register");
    }

    @GetMapping("/checkSession")
    public ResponseEntity<String> checkSession(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session != null && !session.isNew()) {
        return ResponseEntity.ok("Session is active");
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Session is not active");
    }
}

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

