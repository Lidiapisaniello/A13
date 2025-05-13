package com.groom.manvsclass.controller;

import com.groom.manvsclass.model.Admin;
import com.groom.manvsclass.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    //Serve al front-end
    @GetMapping("/usernameAdmin")
    @ResponseBody
    public String getUsernameAdmin(@CookieValue(name = "jwt", required = false) String jwt){
        return adminService.getUsernameAdmin(jwt);
    }

    @GetMapping("/admins_list")
    @ResponseBody
    public Object getAllAdmins(@CookieValue(name = "jwt", required = false) String jwt) {
        return adminService.getAllAdmins(jwt);
    }

    @PostMapping("/password_change_admin")
    @ResponseBody
    public ResponseEntity<?> changePasswordAdmin(@RequestBody Admin admin1, @CookieValue(name = "jwt", required = false) String jwt, HttpServletRequest request) {
        return adminService.changePasswordAdmin(admin1, jwt);
    }

    @PostMapping("/password_reset_admin")
    @ResponseBody
    public ResponseEntity<?> resetPasswordAdmin(@RequestBody Admin admin1, @CookieValue(name = "jwt", required = false) String jwt, HttpServletRequest request) {
        return adminService.resetPasswordAdmin(admin1, jwt);
    }

    @PostMapping("/invite_admins")
    @ResponseBody
    public ResponseEntity<?> inviteAdmins(@RequestBody Admin admin1, @CookieValue(name = "jwt", required = false) String jwt, HttpServletRequest request) {
        return adminService.inviteAdmins(admin1, jwt);
    }

    @PostMapping("/login_with_invitation")
    @ResponseBody
    public ResponseEntity<?> loginWithInvitation(@RequestBody Admin admin1, @CookieValue(name = "jwt", required = false) String jwt, HttpServletRequest request) {
        return adminService.loginWithInvitation(admin1, jwt);
    }

    @PostMapping("/registraAdmin")
    @ResponseBody
    public ResponseEntity<?> registraAdmin(@RequestBody Admin admin1, @CookieValue(name = "jwt", required = false) String jwt) {
        return adminService.registraAdmin(admin1, jwt);
    }

    @GetMapping("/admins/{username}")
    @ResponseBody
    public ResponseEntity<Admin> getAdminByUsername(@PathVariable String username, @CookieValue(name = "jwt", required = false) String jwt) {
        return adminService.getAdminByUsername(username, jwt);
    }

    @PostMapping("/loginAdmin")
    @ResponseBody
    public ResponseEntity<String> loginAdmin(@RequestBody Admin admin1, @CookieValue(name = "jwt", required = false) String jwt, HttpServletResponse response) {
        return adminService.loginAdmin(admin1, jwt, response);
    }


}
