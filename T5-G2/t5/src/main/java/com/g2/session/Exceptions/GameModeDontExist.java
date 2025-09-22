package com.g2.session.Exceptions;

/**
 * Eccezione personalizzata che viene lanciata quando un GameMode non esiste.
 */
public class GameModeDontExist extends RuntimeException {

    // Costruttore che accetta un messaggio di errore
    public GameModeDontExist(String message) {
        super(message); // Passa il messaggio alla classe madre (RuntimeException)
    }

    // Costruttore che accetta un messaggio di errore e una causa (eccezione originale)
    public GameModeDontExist(String message, Throwable cause) {
        super(message, cause); // Passa sia il messaggio che la causa alla classe madre
    }
}
