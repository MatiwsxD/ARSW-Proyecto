package edu.eci.arsw.warGame.services;



import edu.eci.arsw.warGame.persistence.autentificationLogin;
import org.springframework.stereotype.Service;

@Service("WarGameLogin")

public class WarGameLogin {
    public boolean Login(String nameLogin) {
        autentificationLogin connection = new autentificationLogin();
        return connection.getUserLogin(nameLogin);
    }

}
