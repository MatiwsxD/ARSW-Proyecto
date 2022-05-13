

class Player {
    constructor(usuario, paisInicial, ColorPlayer){
        this.usuario = usuario;
        this.paisInicial =paisInicial;
        this.colorPlayer = ColorPlayer;
    }

    get getUser(){
        return this.usuario;
    }
    get getPaisInicial(){
        return this.paisInicial;
    }
    get colorJugador(){
        return this.ColorPlayer;
    }


}