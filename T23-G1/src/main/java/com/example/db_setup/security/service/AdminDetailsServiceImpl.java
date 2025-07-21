package com.example.db_setup.security.service;

import com.example.db_setup.model.Admin;
import com.example.db_setup.model.repository.AdminRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {

    private final AdminRepository adminRepository;

    public AdminDetailsServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
        return UserDetailsImpl.build(admin);
    }
}
