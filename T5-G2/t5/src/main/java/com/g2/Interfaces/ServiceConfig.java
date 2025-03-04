package com.g2.Interfaces;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "services")
@Component
public class ServiceConfig {
    private String enabled;
    private Map<String, String> mapping;

    public String getEnabled() {
        return enabled != null ? enabled : "";
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}

