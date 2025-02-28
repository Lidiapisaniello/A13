package com.groom.manvsclass.model;

public enum ServiceURL {
    T2("t23-g1-app-1", 8080),
    T4("t4-g18-app-1", 3000),
    T7("remoteccc-app-1", 1234),
    T8("prototipo20-t8_generazione-1", 3080);

    private final String host;
    private final int port;

    ServiceURL(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getServiceURL() {
        return String.format("%s:%d", host, port);
    }
}
