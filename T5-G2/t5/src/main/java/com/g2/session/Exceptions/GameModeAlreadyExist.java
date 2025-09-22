package com.g2.session.Exceptions;

/**
 * Eccezione personalizzata che viene lanciata quando si tenta di creare un GameMode già esistente.
 */
public class GameModeAlreadyExist extends RuntimeException {

    // Costruttore che accetta un messaggio di errore
    public GameModeAlreadyExist(String message) {
        super(message); // Passa il messaggio alla classe madre (RuntimeException)
    }

    // Costruttore che accetta un messaggio di errore e una causa (eccezione originale)
    public GameModeAlreadyExist(String message, Throwable cause) {
        super(message, cause); // Passa sia il messaggio che la causa alla classe madre
    }
}
