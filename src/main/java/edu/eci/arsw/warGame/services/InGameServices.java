package edu.eci.arsw.warGame.services;

import edu.eci.arsw.warGame.model.Player;

import java.util.ArrayList;
import java.util.Set;

public interface InGameServices {
    public void registerPlayerToRace(Player player) throws ServicesException;
    public ArrayList<Player> getRegisteredPlayers() throws ServicesException;
}
