package com.example.db_setup.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ServiceURL {
    @Value("${services.t4.endpoint}")
    private String t4Endpoint;

    @Value("${services.t4.port}")
    private int t4Port;

    @PostConstruct
    public void init() {
        System.out.println("🔹 T4 Endpoint: " + t4Endpoint);
        System.out.println("🔹 T4 Port: " + t4Port);
    }

    public String getT4ServiceURL() {
        return String.format("%s:%d", t4Endpoint, t4Port);
    }
}
