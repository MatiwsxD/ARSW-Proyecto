package edu.eci.arsw.warGame.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionSQL {
    Connection conn=null;
    private String url = "jdbc:postgresql://ec2-54-80-122-11.compute-1.amazonaws.com:5432/df2gcac2r9a3ai?sslmode=require";
    private String usuario = "wytppaqzpczwfj";
    private String clave = "28ad99361a19eba5e87ce473a3bbd4d1a718db0c2dfd591d47b5436143ffc21b";

    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection(url,usuario,clave);

        } catch (Exception e) {
            Logger.getLogger(autentificationLogin.class.getName()).log(Level.SEVERE, null, e);
            //System.out.println("Error conexion base de datos");
        }
        return conn;
    }

}