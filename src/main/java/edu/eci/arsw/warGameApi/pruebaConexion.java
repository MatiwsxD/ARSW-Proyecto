package edu.eci.arsw.warGameApi;

import edu.eci.arsw.warGame.persistence.autentificationLogin;
import edu.eci.arsw.warGame.services.WarGameLogin;
import org.springframework.boot.SpringApplication;

public class pruebaConexion {
    public static void main(String[] args) {
        autentificationLogin tabla = new autentificationLogin();
        tabla.getTable();

    }

}
