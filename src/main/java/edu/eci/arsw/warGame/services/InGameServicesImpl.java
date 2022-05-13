package edu.eci.arsw.warGame.services;

import edu.eci.arsw.warGame.model.Player;

import edu.eci.arsw.warGame.persistence.autentificationLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
}
