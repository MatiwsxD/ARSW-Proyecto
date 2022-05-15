class Region {
    constructor(id, dueño, canttropas){
        this.id = id;
        this.dueño =dueño;
        this.canttropas = canttropas;
    }

    get getId(){
        return this.id;
    }
    get getDueño(){
        return this.dueño;
    }
    get getCanttropas(){
        return this.canttropas;
    }
    setDueño(dueño){
        this.dueño=dueño;
    }
    settropasTotal(canttropas){
        this.canttropas = canttropas;
    }


}