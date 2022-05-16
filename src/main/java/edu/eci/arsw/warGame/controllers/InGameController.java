package edu.eci.arsw.warGame.controllers;

import edu.eci.arsw.warGame.model.Player;
import edu.eci.arsw.warGame.model.Region;
import edu.eci.arsw.warGame.services.InGameServices;
import edu.eci.arsw.warGame.services.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(value ="/wargame") 
public class InGameController {

    @Autowired
    InGameServices servicios;

    boolean temp = true;

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

    @RequestMapping(value = "/putregions", method = RequestMethod.PUT)
    public ResponseEntity<?> putAllRegions(@RequestBody ArrayList<Region> Regiones){
        try {
            servicios.registerRegiones(Regiones);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (ServicesException ex){
            return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/updateallregion" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateAllRegion(@RequestBody ArrayList<Region> Regiones){
        try{
            if(temp){
                servicios.reiniciarGame(Regiones);
                temp = false;
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (ServicesException ex){
            return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/updateregion" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateRegion(@RequestBody Region region){
        try{
            servicios.updateRegiones(region);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (ServicesException ex){
            return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/getRegion/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRegion(@PathVariable(name = "id") String id){
        try{

            return new ResponseEntity<>(servicios.getRegion(id),HttpStatus.ACCEPTED);
        } catch (ServicesException ex){
            return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.NOT_FOUND);
        }
    }

    
}
