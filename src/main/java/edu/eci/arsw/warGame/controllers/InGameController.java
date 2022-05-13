package edu.eci.arsw.warGame.controllers;

import edu.eci.arsw.warGame.model.Player;
import edu.eci.arsw.warGame.services.InGameServices;
import edu.eci.arsw.warGame.services.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value ="/wargame") 
public class InGameController {

    @Autowired
    InGameServices servicios;

    @RequestMapping(value = "/getplayers", method = RequestMethod.GET)   //get(localhost:8080/wargame/getplayers)
    public ResponseEntity<?> getPlayers() throws ServicesException {
        try {
            return new ResponseEntity<>(servicios.getRegisteredPlayers(), HttpStatus.ACCEPTED);
        } catch (ServicesException ex){
            return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/putplayer", method = RequestMethod.PUT)    //put(localhost:8080/wargame/putplayer)
    public  ResponseEntity<?> putPlayer(@RequestBody Player player) throws ServicesException {
        try{
            servicios.registerPlayerToRace(player);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ServicesException ex){
            return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
