let Usuario;
let dinero = 0;
let onPosetion = new Map();
let start = true;
var colorCliente;
let departamentosProp=[];

let aumDinero = function(){
    setInterval(function(){
        dinero++
        let T1 =document.getElementById("Dinero");
        T1.textContent=dinero;
    }, 10000-(departamentosProp)*10);
}


let loadAndAddlistener = function(){
    paths = document.getElementsByTagName("path");
    for (var i = 0; i < paths.length; i++){
        paths[i].addEventListener("click", function (event) {
            const bid = event.target.id;
            onStart(bid);
            
        });
    }
}
let showme = function(){
    console.log(Usuario);
}

let onStart = function(id){
    if (start){
        setPaisColor(id, colorCliente);
        Usuario = new Player(localStorage.getItem("Usuario"), id, colorCliente);
        onPosetion.set(id,50);
        addPlayer();
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

let getCountry=function(id){
    let contry = getElementById(id);


}

var addPlayer = async()=>{
     y = await fetch('http://localhost:8080/wargame/putplayer', {
        method: "PUT",
        body: JSON.stringify(Usuario),
        headers: {"Content-type" : "application/json"}
    }
    ).then(res=>console.log(res));

    x = await fetch('http://localhost:8080/wargame/getplayers', {
        mode: 'no-cors',
        method: 'GET',
        headers: {
            "Content-type": "application/json"
        }
    })
        .then(response => response.json());
    console.log(x);
}


var help = function(){
    var socket = new SockJS('/wargamews');
    stompClient = Stomp.over(socket);
    //stompClient.subscribe("/topic/user", null);
}
aumDinero();

//loadAndAddlistener();
