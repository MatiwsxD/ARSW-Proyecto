package edu.eci.arsw.warGame.controllers;

import edu.eci.arsw.warGame.services.WarGameLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class UserController {
    @Autowired
    @Qualifier("WarGameLogin")
    WarGameLogin login;

    @GetMapping("/consult/{userName}/{password}")
    public ResponseEntity<?> register(@PathVariable(value = "userName") String userName, @PathVariable(value = "password") String contraseña) {
       
        try {
            return new ResponseEntity<>(login.Login(userName, contraseña), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
