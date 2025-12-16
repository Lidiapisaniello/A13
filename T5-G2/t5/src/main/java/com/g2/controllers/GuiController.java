package com.g2.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.g2.components.GenericObjectComponent;
import com.g2.components.PageBuilder;
import com.g2.components.ServiceObjectComponent;
import com.g2.components.VariableValidationLogicComponent;
import com.g2.interfaces.ServiceManager;
import com.g2.model.User;
import com.g2.security.JwtRequestContext;
import com.g2.session.SessionService;
import com.g2.session.Sessione;
import com.g2.session.exception.SessionAlredyExist;
import com.g2.session.exception.SessionDoesntExistException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import testrobotchallenge.commons.models.opponent.GameMode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@Controller
@AllArgsConstructor
public class GuiController {
    private static final Logger logger = LoggerFactory.getLogger(GuiController.class);
    private final ServiceManager serviceManager;
    private final SessionService sessionService;

    @GetMapping("/main")
    public String showMain(Model model, @CookieValue(name = "jwt", required = false) String jwt) {
        PageBuilder main = new PageBuilder(serviceManager, "main", model, jwt);
        try {
            sessionService.createSession(main.getUserId());
        } catch (SessionAlredyExist e) {
            logger.info("Esiste già una sessione per playerId {}", main.getUserId());
        }
        return main.handlePageRequest();
    }





    @GetMapping("/gamemode")
    public String showGameMode(Model model, @RequestParam(value = "mode", required = false) String mode) {
        if ("Sfida".equals(mode) || "Allenamento".equals(mode) || "PartitaSingola".equals(mode)) {
            PageBuilder gameModePage = new PageBuilder(serviceManager, "gamemode", model);
            VariableValidationLogicComponent valida = new VariableValidationLogicComponent(mode);
            valida.setCheckNull();
            List<String> gameModes = Arrays.asList("Sfida", "Allenamento");
            valida.setCheckAllowedValues(gameModes);
            ServiceObjectComponent availableClasses = new ServiceObjectComponent(serviceManager, "lista_classi", "T1", "getClasses");
            ServiceObjectComponent availableRobots = new ServiceObjectComponent(serviceManager, "available_robots", "T1", "getOpponentsSummary");
            gameModePage.setObjectComponents(availableClasses, availableRobots);
            return gameModePage.handlePageRequest();
        }
        if ("Scalata".equals(mode)) {
            PageBuilder gameModePage = new PageBuilder(serviceManager, "gamemode_scalata", model);
            return gameModePage.handlePageRequest();
        }
        return "main";
    }

    @GetMapping("/editor")
    public String editorPage(Model model, @RequestParam(value = "ClassUT") String ClassUT, @RequestParam(value = "mode") GameMode mode) {
        PageBuilder editor = new PageBuilder(serviceManager, "editor", model, JwtRequestContext.getJwtToken());
        try {
            Sessione sessione = sessionService.getSession(editor.getUserId());
            editor.setObjectComponents(new GenericObjectComponent("previousGameObject", sessione.getGame(mode)));
        } catch (SessionDoesntExistException e) {
            return "redirect:/main";
        }
        ServiceObjectComponent classeUT = new ServiceObjectComponent(serviceManager, "classeUT", "T1", "getClassUnderTest", ClassUT);
        editor.setObjectComponents(classeUT);
        return editor.handlePageRequest();
    }

    @GetMapping("/leaderboard")
    public String leaderboard(Model model, @CookieValue(name = "jwt", required = false) String jwt) {
        PageBuilder leaderboard = new PageBuilder(serviceManager, "leaderboard", model);
        ServiceObjectComponent listaUtenti = new ServiceObjectComponent(serviceManager, "listaPlayers", "T23", "GetUsers");
        leaderboard.setObjectComponents(listaUtenti);
        return leaderboard.handlePageRequest();
    }

    @GetMapping("/leaderboardScalata")
    public String getLeaderboardScalata(Model model, @CookieValue(name = "jwt", required = false) String jwt) {
        Boolean Auth = (Boolean) serviceManager.handleRequest("T23", "GetAuthenticated", jwt);
        if (Auth) return "leaderboardScalata";
        return "redirect:/login";
    }

    @GetMapping("/editor_old")
    public String getEditorOld(Model model, @CookieValue(name = "jwt", required = false) String jwt) {
        PageBuilder main = new PageBuilder(serviceManager, "editor_old", model);
        main.setAuth(jwt);
        return main.handlePageRequest();
    }
}