package edu.eci.arsw.warGame.services;

import edu.eci.arsw.warGame.model.Player;
import edu.eci.arsw.warGame.model.Region;

import java.util.ArrayList;

public interface InGameServices {
    public void registerPlayerToRace(Player player) throws ServicesException;
    public ArrayList<Player> getRegisteredPlayers() throws ServicesException;
    public void registerRegiones(ArrayList<Region> arrayRegiones) throws  ServicesException;
    public void updateRegiones(Region region) throws ServicesException;
    public void reiniciarGame(ArrayList<Region> arrayRegiones) throws  ServicesException;
    public  Region getRegion(String idRegion) throws ServicesException;
}
