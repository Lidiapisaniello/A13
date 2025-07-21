package com.example.db_setup.service;

import com.example.db_setup.model.Admin;
import com.example.db_setup.model.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin addNewAdmin(String name, String surname, String email, String password) {
        Admin admin = new Admin(name, surname, email, password);
        return adminRepository.save(admin);
    }

    public Admin getAdminByEmail(String email) {
        return adminRepository.getAdminByEmail(email).orElse(null);
    }
}
