package com.example.db_setup.controller;

import com.example.db_setup.model.Admin;
import com.example.db_setup.model.dto.gamification.AdminSummaryDTO;
import com.example.db_setup.model.repository.AdminRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admins")
public class AdminController {

    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<AdminSummaryDTO>> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();

        List<AdminSummaryDTO> adminSummaryDTOS = new ArrayList<>();
        for (Admin admin : admins) {
            adminSummaryDTOS.add(new AdminSummaryDTO(admin.getName(), admin.getSurname(), admin.getEmail()));
        }
        return ResponseEntity.ok(adminSummaryDTOS);
    }
}
