var url;

var consultaUser = async()=>{
    user = document.getElementById("Autor").value;
    url = 'http://localhost:8080/consult/' + user
    data1 = await fetch(url, {
        mode: 'no-cors',
        method: 'GET',
        headers: {
        "Content-type": "application/json"
            }
        })
        .then(response => response.json());

    if (data1){
        location.href = "Prueba.html";
        localStorage.setItem("Usuario",user);
    }
    else{
        var t2 = document.getElementById("Resultado");
        t2.textContent="El usuario no se encuentra registrado en la base de datos"
    }



}
