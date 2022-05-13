package edu.eci.arsw.warGame.model;

public class Player {
    String usuario;
    String paisInicial;
    String colorPlayer;

    public String getPaisInicial() {
        return paisInicial;
    }

    public String getColorPlayer() {
        return colorPlayer;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setPaisInicial(String paisInicial) {
        this.paisInicial = paisInicial;
    }

    public void setUsuario(String usuario) {this.usuario = usuario;}

    public void setColorPlayer(String colorPlayer) {
        this.colorPlayer = colorPlayer;
    }
}
