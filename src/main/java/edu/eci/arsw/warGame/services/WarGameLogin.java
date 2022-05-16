package edu.eci.arsw.warGame.services;



import edu.eci.arsw.warGame.persistence.autentificationLogin;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service("WarGameLogin")

public class WarGameLogin {
    public boolean Login(String nameLogin, String contraseña) {
        autentificationLogin connection = new autentificationLogin();
        byte[] bytesDecodificados = Base64.getDecoder().decode(nameLogin);
        String nameLogin2 = new String(bytesDecodificados);
        byte[] bytesDecodificados2 = Base64.getDecoder().decode(contraseña);
        String contraseña2 = new String(bytesDecodificados2);

        return connection.getUserLogin(nameLogin2, contraseña2);
    }

}
