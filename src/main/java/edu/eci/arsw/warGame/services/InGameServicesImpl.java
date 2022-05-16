package edu.eci.arsw.warGame.services;

import edu.eci.arsw.warGame.model.Player;

import edu.eci.arsw.warGame.model.Region;
import edu.eci.arsw.warGame.persistence.autentificationLogin;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class InGameServicesImpl implements InGameServices{


    @Override
    public void registerPlayerToRace(Player player) throws ServicesException {
        autentificationLogin connection = new autentificationLogin();
        connection.actualizarUser(player.getUsuario(), player.getColorPlayer(), player.getPaisInicial());
        //listaJugadores.add(player);
    }

    @Override
    public ArrayList<Player> getRegisteredPlayers() throws ServicesException {
        autentificationLogin connection = new autentificationLogin();
        ArrayList<Player> data = connection.getTable();
        return data;
    }
    @Override
    public void registerRegiones(ArrayList<Region> arrayRegiones){
        autentificationLogin connection = new autentificationLogin();
        for(int i =0; i<arrayRegiones.size(); i++) {
            Region temp = arrayRegiones.get(i);
            connection.insertRegion(temp.getId(), temp.getDueño(), temp.getCanttropas());
        }
    }

    @Override
    public void reiniciarGame(ArrayList<Region> arrayRegiones){
        autentificationLogin connection = new autentificationLogin();
        for(int i =0; i<arrayRegiones.size(); i++) {
            Region temp = arrayRegiones.get(i);
            connection.actualizarRegiones(temp.getId(), temp.getDueño(), "30");
        }
    }

    @Override
    public void updateRegiones(Region region) throws ServicesException {
        autentificationLogin connection = new autentificationLogin();
        connection.actualizarRegiones(region.getId(), region.getDueño(), region.getCanttropas());
    }

    @Override
    public Region getRegion(String id){
        autentificationLogin connection = new autentificationLogin();
        return connection.getRegion(id);
    }
}
