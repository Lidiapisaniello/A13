/*MODIFICA (5/11/2024) - Refactoring task T1
 * AdminService ora si occupa di implementare i servizi relativi all'Admin
 */
package com.groom.manvsclass.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.groom.manvsclass.model.Achievement;
import com.groom.manvsclass.model.ClassUT;
import com.groom.manvsclass.model.Statistic;
import com.groom.manvsclass.model.repository.*;
import com.commons.model.Gamemode;
import com.commons.model.Robot;
import com.commons.model.StatisticRole;


//MODIFICA (14/05/2024) : Importazione delle classi Scalata e ScalataRepository

//MODIFICA (12/02/2024) : Gestione autenticazione
import com.groom.manvsclass.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;

//MODIFICA(11/02/2024): Gestione sessione tramite JWT
import com.groom.manvsclass.util.filesystem.download.FileDownloadUtil;

//MODIFICA (13/02/2024) : Autenticazione token proveniente dai players

 //MODIFICA (15/02/2024) : Servizio di posta elettronica
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

//MODIFICA (11/02/2024) : Controlli sul form registrazione
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AdminService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private final SearchRepositoryImpl srepo;

    @Autowired
    private ClassRepository repo;

    @Autowired
    private OperationRepository orepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private AdminRepository arepo;

    //MODIFICA (15/02/2024) : Servizio di posta elettronica
    @Autowired
    private EmailService emailService;

    //MODIFICA (11/02/2024) : Controlli sul form registrazione
    @Autowired
    private PasswordEncoder myPasswordEncoder;

    private final Admin userAdmin= new Admin("default","default","default","default","default");

    //MODIFICA (18/09/2024) : Inizializzazione del repository per gli Achievement
    @Autowired
    private AchievementRepository achievementRepository;

    //MODIFICA (07/10/2024) : Inizializzazione del repository per le Statistiche
    @Autowired
    private StatisticRepository statisticRepository;

    
    private final LocalDate today = LocalDate.now();

    public AdminService(SearchRepositoryImpl srepo) {
	    this.userAdmin.setUsername("default");
	    this.srepo=srepo;
	}



    public ResponseEntity<List<ClassUT>> filtraClassi(String category, String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            List<ClassUT> classiFiltrate = srepo.filterByCategory(category);
            return ResponseEntity.ok().body(classiFiltrate);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    public ResponseEntity<List<ClassUT>> filtraClassi(String text, String category, String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            List<ClassUT> classiFiltrate = srepo.searchAndFilter(text, category);
            return ResponseEntity.ok().body(classiFiltrate);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    public ResponseEntity<?> registraAdmin(Admin admin1, String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("registraAdmin_already_logged_in");
        }

        //Controlli
		//1: Possibilità di inserire più nomi separati da uno spazio
        if (admin1.getNome().length() >= 2 && admin1.getNome().length() <= 30 && Pattern.matches("[a-zA-Z]+(\\s[a-zA-Z]+)*", admin1.getNome())) {
            this.userAdmin.setNome(admin1.getNome());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("registraAdmin_invalid_name");
        }

        //2: Possibilità di inserire più parole separate da uno spazio ed eventualmente da un apostrofo
        if (admin1.getCognome().length() >= 2 && admin1.getCognome().length() <= 30 && Pattern.matches("[a-zA-Z]+(\\s?[a-zA-Z]+\\'?)*", admin1.getCognome())) {
            this.userAdmin.setCognome(admin1.getCognome());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("registraAdmin_invalid_surname");
        }

        //3: L'username deve rispettare necessariamente il seguente formato: "[username di lunghezza compresa tra 2 e 30 caratteri]"
        if (admin1.getUsername().length() >= 2 && admin1.getUsername().length() <= 30) {
            this.userAdmin.setUsername(admin1.getUsername());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("registraAdmin_invalid_username");
        }

        //4: L'email deve essere valida
        if (Pattern.matches("^[\\w!#$%&*+/=?{|}~^-]+(?:\\.[\\w!#$%&*+/=?{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,63}$", admin1.getEmail())) {
            Admin existingAdmin = arepo.findById(admin1.getEmail()).orElse(null);
            if (existingAdmin != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("registraAdmin_email_invalid");
            }
            this.userAdmin.setEmail(admin1.getEmail());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("registraAdmin_email_exists");
        }

        //5: La password deve contenere almeno una lettera maiuscola, una minuscola, un numero ed un carattere speciale e deve essere lunga tra gli 8 e i 16 caratteri
        Matcher m = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$").matcher(admin1.getPassword());
        if (admin1.getPassword().length() > 16 || admin1.getPassword().length() < 8 || !m.matches()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("registraAdmin_invalid_password");
        }

        String crypted = myPasswordEncoder.encode(admin1.getPassword());
        this.userAdmin.setPassword(crypted);

        Admin savedAdmin = arepo.save(this.userAdmin);
        return ResponseEntity.ok().body(savedAdmin);
    }

    public Object getAllAdmins(String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            return arepo.findAll();
        } else {
            return new RedirectView("/loginAdmin");
        }
    }

    public ResponseEntity<?> changePasswordAdmin(Admin admin1, String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("passwordChange_already_logged");
        }

        Admin admin = arepo.findById(admin1.getEmail()).orElse(null);
        if (admin == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("passwordChange_email_not_found");
        }

        Admin admin_reset = srepo.findAdminByResetToken(admin1.getResetToken());
        if (!admin_reset.getResetToken().equals(admin1.getResetToken())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("passwordChange_invalid_token");
        }

        Matcher m = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$").matcher(admin1.getPassword());
        if (admin1.getPassword().length() > 16 || admin1.getPassword().length() < 8 || !m.matches()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("passwordChange_invalid_password");
        }

        String crypted = myPasswordEncoder.encode(admin1.getPassword());
        admin1.setPassword(crypted);
        admin.setPassword(admin1.getPassword());
        admin1.setResetToken(null);
        admin.setResetToken(admin1.getResetToken());

        Admin savedAdmin = arepo.save(admin);
        return ResponseEntity.ok().body(savedAdmin);
    }

    public ResponseEntity<?> resetPasswordAdmin(Admin admin1, String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("resetPassword_already_logged");
        }

        Admin admin = arepo.findById(admin1.getEmail()).orElse(null);
        if (admin == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("resetPassword_email_not_found");
        }

        String resetToken = jwtService.generateToken(admin);
        admin.setResetToken(resetToken);

        Admin savedAdmin = arepo.save(admin);
        try {
            emailService.sendPasswordResetEmail(savedAdmin.getEmail(), savedAdmin.getResetToken());
            return ResponseEntity.ok().body(savedAdmin);
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("resetPassword_email_send_error");
        }
    }

    public ResponseEntity<?> inviteAdmins(Admin admin1, String jwt) {
        if (!jwtService.isJwtValid(jwt)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Attenzione, non sei loggato");
        }

        //Controlliamo che non esista nel repository un admin con la mail specificata nell'invito
        Admin admin = arepo.findById(admin1.getEmail()).orElse(null);
        if (admin != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email trovata, la persona che stai tentando di invitare è già un amministratore!");
        }

        Admin new_admin = new Admin("default", "default", "default", "default", "default");
        new_admin.setEmail(admin1.getEmail());

        String invitationToken = jwtService.generateToken(new_admin);
        new_admin.setInvitationToken(invitationToken);

        Admin savedAdmin = arepo.save(new_admin);
        try {
            emailService.sendInvitationToken(savedAdmin.getEmail(), savedAdmin.getInvitationToken());
            return ResponseEntity.ok().body("Invitation token inviato correttamente all'indirizzo:" + savedAdmin.getEmail());
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore nell'invio del messaggio di posta");
        }
    }

    public ResponseEntity<?> loginWithInvitation(Admin admin1, String jwt) {
        if (jwtService.isJwtValid(jwt)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Attenzione, hai già un token valido!");
        }

        Admin admin = arepo.findById(admin1.getEmail()).orElse(null);
        if (admin == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email non trovata");
        }

        Admin admin_invited = srepo.findAdminByInvitationToken(admin1.getInvitationToken());
        if (!admin_invited.getInvitationToken().equals(admin1.getInvitationToken())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token di invito invalido!");
        }

        admin.setEmail(admin1.getEmail());

        if (admin1.getNome().length() >= 2 && admin1.getNome().length() <= 30 && Pattern.matches("[a-zA-Z]+(\\s[a-zA-Z]+)*", admin1.getNome())) {
            admin.setNome(admin1.getNome());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome non valido");
        }

        if (admin1.getCognome().length() >= 2 && admin1.getCognome().length() <= 30 && Pattern.matches("[a-zA-Z]+(\\s?[a-zA-Z]+\\'?)*", admin1.getCognome())) {
            admin.setCognome(admin1.getCognome());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cognome non valido");
        }

        if (admin1.getUsername().length() >= 2 && admin1.getUsername().length() <= 30 && Pattern.matches(".*_invited$", admin1.getUsername())) {
            admin.setUsername(admin1.getUsername());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username non valido, deve rispettare il seguente formato: [username di lunghezza compresa tra 2 e 30 caratteri]_invited");
        }

        Matcher m = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$").matcher(admin1.getPassword());
        if (admin1.getPassword().length() > 16 || admin1.getPassword().length() < 8 || !m.matches()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password non valida! La password deve contenere almeno una lettera maiuscola, una minuscola, un numero ed un carattere speciale e deve essere lunga tra gli 8 e i 16 caratteri");
        }

        String crypted = myPasswordEncoder.encode(admin1.getPassword());
        admin1.setPassword(crypted);
        admin.setPassword(admin1.getPassword());

        admin1.setInvitationToken(null);
        admin.setInvitationToken(admin1.getInvitationToken());

        Admin savedAdmin = arepo.save(admin);
        return ResponseEntity.ok().body(savedAdmin);
    }

    public ResponseEntity<Admin> getAdminByUsername(String username, String jwt) {
        if (jwtService.isJwtValid(jwt)) {

			System.out.println("Token valido, può ricercare admin per username (/admins/{username})");
			Admin admin = srepo.findAdminByUsername(username);
			if (admin != null) {

				System.out.println("Operazione avvenuta con successo (/admins/{username})");
				return ResponseEntity.ok().body(admin);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Ritorna 404 Not Found
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Ritorna 401 Unauthorized
		}
    }

    public ResponseEntity<String> loginAdmin(Admin admin1, String jwt, HttpServletResponse response) {
        if (jwtService.isJwtValid(jwt)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("loginAdmin_login_error_already_logged");
        }

        if (admin1.getUsername().isEmpty() || admin1.getPassword().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("loginAdmin_login_error_fields_incomplete");
        }

        Admin admin = srepo.findAdminByUsername(admin1.getUsername());

        // (MODIFICA 14/05/2024) Check se admin esiste già
        if (admin == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("loginAdmin_login_error_not_found");
        }

        boolean passwordMatches = myPasswordEncoder.matches(admin1.getPassword(), admin.getPassword());

        if (passwordMatches) {
            String token = jwtService.generateToken(admin);

            Cookie jwtTokenCookie = new Cookie("jwt", token);
            jwtTokenCookie.setMaxAge(3600);
            response.addCookie(jwtTokenCookie);
            
            return ResponseEntity.ok("Autenticazione avvenuta con successo");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("loginAdmin_login_error_fields_incorrect");
        }
    }




/*
    public String test() {
        return "test T1";
    }

 */





    public String getUsernameAdmin(String jwt) {
        if(jwtService.isJwtValid(jwt)){
            String usernameAdmin= jwtService.getAdminFromJwt(jwt);
            return usernameAdmin;
        }
        return "devi prima loggarti!";
    }



}