package edu.eci.arsw.warGame.services;

public class ServicesException extends Exception{
    public ServicesException(String message) {
        super(message);
    }

    public ServicesException(String message, Throwable cause) {
        super(message, cause);
    }
}
