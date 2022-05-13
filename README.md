# WarGame
## ✒️Autores ✒️

* **Julián Adolfo Peña**
* **Juan Mateo Mejia**

## 🚀Resumen🚀

_Este juego es un proyecto de ARSW(Arquitectura de software) y esta basado en el juego State.io._


_El juego se diferencia de State.io ya que vamos a introducir funciones multijugador, donde podrá conectarse a una sala multijugador y luchar contra sus amigos para hacerse con toda la región._

### 📋Descripción📋

El juego va a ser montado en una aplicación web cuya idea principal es un juego de estrategia donde los jugadores podrán unirse a diferentes salas y asumir el mando de su nación favorita para derrotar a los otros jugadores y conquistar todo el territorio. La partida se termina cuando quede una nación en pie que haya conseguido dominar toda la sala. Con las partidas ganadas podrás ganar créditos que te ayudaran a mejorar la cantidad de tropas iniciales, el dinero que ganas por partida y la cantidad de tropas que generas por segundo.

* Las salas van a tener un limite de personas dependiendo del continente elegido.
* La jugabilidad es simple, todos los jugadores van a tener un numero inicial de tropas, cada cierto tiempo va aumentando las tropas del jugador, este va a poder usar dichas tropas para conquistar los diferentes terrenos.
* Cuando un jugador ataque a un oponente o a un terreno baldío, la totalidad de sus tropas se van a mover.
* El mapa va a contener 2 tipos de Naciones, los territorios ocupados por jugadores y los territorios baldíos, estos territorios tienen un numero inicial de tropas que se determinara calculando el MMR de todos los jugadores en la sala (El MMR se determinara en base al nivel de las mejoras que tengan los jugadores de la sala).
* Los jugadores van a poder hacer mejoras a su perfil, haciendo que en partida tengan mas tropas iniciales, que produzcan mas tropas cada cierto tiempo o incluso que las recompensas por ganar sean mejores.


### 🤓Casos de uso 🤓
## Pagina de login


![](https://i.ibb.co/nCfCfkG/1.png)


## Pagina principal



![](https://i.ibb.co/q1x0Xyq/2.png)


## Durante el juego


![](https://i.ibb.co/mXp7Jwc/3.png)

## Finalizar el juego


![xd](https://i.ibb.co/zFDXzbh/4.png)



### ⌨️Historias de uso ⌨️



```
* Como Jugador QUIERO crear una cuenta PARA PODER jugar y guardar mi progreso en el juego.
* Criterios de aceptación: 
- Que no haya una cuenta registrada con el mismo correo.
- Que la contraseña tenga una longitud mínima.

```

```
* Como Jugador QUIERO crear una sala PARA PODER jugar con amigos.
* Criterios de aceptación: 
- Al crear una debe ponerle un nombre 
- Si es una sala privada debe generar un código único
- La cantidad de usuarios por sala puede se máximo de 8 personas 
```
```
* Como Jugador QUIERO unirme a una sala previamente creada PARA PODER jugar con gente que este conectada.
* Criterios de aceptación: 
- Un jugador no puede estar en dos salas al mismo tiempo
- Abandonar una partida supondrá una penalización 
```
```
* Como Jugador QUIERO comprar mejoras PARA PODER mejorar las estadísticas de mi perfil y obtener ventajas.
* Criterios de aceptación: 
-Si no tiene créditos no va a poder comprar las mejoras
-Las mejoras solo se podrán comprar una sola vez
-Habrá un limite de mejoras
-Las mejoras disponibles deben ser visibles para el jugador
```
```
* Como Jugador QUIERO ver las estadísticas de mi cuenta PARA PODER ver el progreso.
* Criterios de aceptación: 
- Las estadísticas se van a generar automáticamente 
- Las estadísticas no se van poder modificar manualmente 
```

```
* Como Jugador QUIERO ver los eventos de la partida PARA PODER tomar decisiones y conseguir la victoria.
* Criterios de aceptación: 
-Los eventos de la partida se generaran automáticamente 
-Los eventos no van a poder ser modificados por el jugador de manera manual 
-Los eventos deben mostrar quien esta siendo atacado y por quien
-Los eventos deben mostrar que jugador quedo eliminado de la partida
```

```
* Como jugador QUIERO ver un ranking de tropas PARA PODER saber quien tiene el equipo mas fuerte.}
* Criterios de aceptación: 
-En el ranking se debe mostrar la cantidad total de tropas
-Los jugadores no podrán modificar estos datos de forma manual
```
```
* Como Jugador QUIERO saber cuantos créditos conseguir al terminar la partida para así PARA PODER comprar mejoras.
* Criterios de aceptación: 
-La cantidad de créditos total ganada debe ser visible una vez terminada la partida
-La cantidad de créditos ganados no podrá ser modificada por el jugador 
```
```
* Como Jugador QUIERO volver a la pagina principal PARA PODER iniciar una nueva partida.
* Criterios de aceptación:
-El jugador no debe poder volver a la misma sala una vez la partida termine
``` 

