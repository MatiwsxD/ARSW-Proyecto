package edu.eci.arsw.warGame.persistence;

import edu.eci.arsw.warGame.model.Player;
import edu.eci.arsw.warGame.model.Region;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class autentificationLogin extends ConexionSQL{
    java.sql.Statement st;
    ResultSet rs;

    public boolean getUserLogin(String iduser) {
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from register where idusuario='" + iduser + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("no se encontro registro");
            return false;
        }

    }

    public void actualizarUser(String iduser, String color, String paisinicial){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update register set color='" + color + "',paisinicial='" + paisinicial + "' where idusuario='" + iduser + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();

        }catch (Exception e) {
            System.out.println("no se encontro registro");
        }
        
    }
    public ArrayList<Player> getTable(){
        ArrayList<Player> datos = new ArrayList<Player>();
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from register;";
            rs = st.executeQuery(sql);

            while(rs.next()){
                Player player = new Player();
                player.setUsuario(rs.getString("idusuario"));
                player.setPaisInicial(rs.getString("paisinicial"));
                player.setColorPlayer(rs.getString("color"));
                datos.add(player);
            }
            st.close();
            conexion.close();


        } catch (Exception e) {
            System.out.println("No se pudo cargar la tabla");
        }
        return datos;

    }


    public  void insertRegion(String id, String dueño, String canttropas){
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into regiones(id,dueño,canttropas) values('" + id + "','" + dueño + "','" + canttropas + "');";
            st.execute(sql);
            st.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("El registro no se guado");
        }
    }
    

    public void actualizarRegiones(String id, String dueño, String canttropas) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update regiones set dueño='" + dueño + "',canttropas='" + canttropas + "' where id='" + id + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar");
        }
    }

    public Region getRegion (String idRegion){
        Region region = new Region();
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from regiones where id='" + idRegion + "';";
            rs = st.executeQuery(sql);
            rs.next();
            region.setId(rs.getString("id"));
            region.setCanttropas(rs.getString("canttropas"));
            region.setDueño(rs.getString("dueño"));
            st.close();
            conexion.close();


        }catch (Exception e){
            System.out.println("Error al Obtener la region");

        }
        return region;
    }

    
}
