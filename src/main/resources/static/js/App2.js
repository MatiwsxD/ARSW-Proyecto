let Usuario;
let dinero = 0;
let start = true;
var colorCliente;
let departamentosProp=[];
let players;
let regiones = [];
var stompClient = null;
let conflicto = [];

let aumDinero = function(){
    setInterval(function(){
        dinero++
        let T1 =document.getElementById("Dinero");
        T1.textContent=dinero;
    }, 700-(departamentosProp)*10);
}


let loadAndAddlistener = function(){
    

    paths = document.getElementsByTagName("path");
    for (var i = 0; i < paths.length; i++){
        let idR = paths[i].getAttribute("id");
        agregarElemento(idR,30);
        paths[i].addEventListener("click", function (event) {
            const bid = event.target.id;

            if(isMyProperty(bid)&&conflicto.length==0){
                comprarUnidades(bid);
                conflicto=[];
            }
            else{
                conflicto.push(bid);
                atacarRegiones();

            }

        });
        regiones.push(new Region(idR, null, 30));
    }
    onStart();
    getPlayers();
    //Put de todo el mapa
}
var agregarElemento = function (id1,tropas){
    const {x,y} = puntoMedio(id1);
    if(start){
        console.log(tropas);
        var regiones = document.getElementById("regiones");
        var center = document.createElementNS('http://www.w3.org/2000/svg', "g");
        center.innerHTML = '<text x='+ '"' + (x-10) + '"' + 'y =' + '"' + (y+5) + '" style="fill:#1effd6;font-weight: bold;">'+tropas+'</text>';
        center.setAttribute("id",id1);
        regiones.appendChild(center);
    }
    else{
        var g = document.getElementsByTagName("g");
        for(let i = 1; i<g.length;i++){
            if(g[i].getAttribute("id")== id1){
                g[i].style.display="none"
            }
        }
        console.log(tropas)
        var regiones = document.getElementById("regiones");
        var center = document.createElementNS('http://www.w3.org/2000/svg', "g");
        center.innerHTML = '<text x='+ '"' + (x-10) + '"' + 'y =' + '"' + (y+5) + '" style="fill:#1effd6;font-weight: bold;">'+tropas+'</text>';
        center.setAttribute("id",id1);
        regiones.appendChild(center);

    }


}

var puntoMedio = function (id) {
    let region = document.getElementById(id);
    let box = region.getBBox();
    var centerPoint = new Object();
    centerPoint.x = box.x + box.width / 2;
    centerPoint.y = box.y + box.height / 2;
    return {
        x: centerPoint.x,
        y: centerPoint.y
    }
}

let atacarRegiones = function (){
    if(conflicto.length ==1 && !isMyProperty(conflicto[0])){
        window.alert("Seleccione la region de donde desea movilizar las tropas");
        //isMyProperty(conflicto[0])
    }

    else if (conflicto.length ==2 && isMyProperty(conflicto[1])){
        console.log(conflicto);
        let atacado = regiones.filter(function(regiones){return regiones.id == conflicto[0];})
        let obj1 = atacado[0];
        let atacante = regiones.filter(function(regiones){return regiones.id == conflicto[1];})
        let obj2 = atacante[0];
        let tropasAtacado = parseInt(obj1.getCanttropas);
        let tropasAtacante = window.prompt('Dijite numero de tropas que desea comprar para esta region');
        if(tropasAtacante>tropasAtacado && (parseInt(tropasAtacante)<obj2.getCanttropas)){
            obj1.setDueño(obj2.getDueño);
            let x =Math.abs(parseInt(obj1.getCanttropas)-parseInt(obj2.getCanttropas));
            obj1.settropasTotal(x);
            let obj11 = document.getElementById(obj1.getId())
            let num = obj11.getAttribute("text")
            console.log(num);

            console.log(obj1);
            updateRegion(obj1)
            //console.log(obj1);
            obj2.settropasTotal(parseInt(obj2.getCanttropas)-parseInt(tropasAtacante));
            console.log(obj2)
            updateRegion(obj2)
            console.log("Lo que le quedaria al atacante" + obj2.getCanttropas);
        }
    }
    else{
        window.alert("La region de donde desea movilizar las tropas no le pertenece");
        conflicto = [];
    }


}

let comprarUnidades = function(bid){
    ntropas = window.prompt('Dijite numero de tropas que desea comprar para esta region');
    if(ntropas<dinero && ntropas != null){
        let region = regiones.filter(function(regiones){return regiones.id == bid;})
        let obj1 = region[0];
        let tempTropas =parseInt(obj1.getCanttropas)  + parseInt(ntropas)
        obj1.settropasTotal(tempTropas);
        updateRegion(obj1);
        agregarElemento(obj1.getId, tempTropas);
        dinero = dinero-ntropas;
    }
    else{
        window.alert("No tiene el dinero suficiente o no selecciono el numero de tropas");
    }
}

let onStart = function(){
    if (start){
        //setPaisColor(id, colorCliente);
        //Usuario = new Player(localStorage.getItem("Usuario"), id, colorCliente);
        
        //addPlayer();

        start =false;
        help();
    }

}

let setColor = function(){
    colorCliente  = document.querySelector('#Color').value;
    console.log(colorCliente);
    
}
let setPaisColor = function(id, color){
    let contry = document.getElementById(id);
    contry.style.fill = color;

}

var updateRegion = async(region)=>{
    y = await fetch('http://localhost:8080/wargame/updateregion', {
        method: "PUT",
        body: JSON.stringify(region),
        headers: {"Content-type" : "application/json"}
    }).then(res=>console.log(res));


}


var addPlayer = async()=>{
     y = await fetch('http://localhost:8080/wargame/putplayer', {
        method: "PUT",
        body: JSON.stringify(Usuario),
        headers: {"Content-type" : "application/json"}
    }).then(res=>console.log(res));

    
}

var getPlayers = async()=>{
    x = await fetch('http://localhost:8080/wargame/getplayers', {
        mode: 'no-cors',
        method: 'GET',
        headers: {
            "Content-type": "application/json"
        }
    }).then(response => response.json());

    let user = x.filter(function(x){return x.usuario == localStorage.getItem("Usuario")})
    Usuario = user[0];
    //console.log(Usuario);
    players = await x;
    for(let Jugador of players){
        let region = regiones.filter(function(regiones){return regiones.id == Jugador.paisInicial;})
        let obj1 = region[0];
        obj1.setDueño(Jugador.usuario);
        setPaisColor(Jugador.paisInicial,Jugador.colorPlayer);
    }
    updateAllRegions();

}

var isMyProperty = function(id){
    var result;
    let region = regiones.filter(function(regiones){return regiones.id == id;})
    let obj1 = region[0];
    //console.log(obj1);
    if(obj1.getDueño == Usuario.usuario){
        result = true;
    }
    else{
        result = false;
    }
    return result;
}
var updateAllRegions = async()=>{
    y = await fetch('http://localhost:8080/wargame/updateallregion', {
        method: "PUT",
        body: JSON.stringify(regiones),
        headers: {"Content-type" : "application/json"}
    }).then(res=>console.log(res));

}


var putAllMap = async()=>{
    y = await fetch('http://localhost:8080/wargame/putregions', {
        method: "PUT",
        body: JSON.stringify(regiones),
        headers: {"Content-type" : "application/json"}
    }).then(res=>console.log(res));

}



var help = async()=>{
    var socket = await new SockJS('/wargamews');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (){});
    //stompClient.subscribe('/events/',function(){}) //Aqui va una funcion de que quiere hacer );
}
aumDinero();

//loadAndAddlistener();
