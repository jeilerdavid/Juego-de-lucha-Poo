# Juego de Lucha Poo
Estudiante: Jeiler David Medina Zapata, Juan Camilo Contreras Ambuila 

Curso:Ingeniería de Software II

Docente:  Jhon Haide Cano Beltrán MSc

Fecha: 14 de mayo de 2025

# Enunciado
   
El objetivo del proyecto es desarrollar un juego de lucha entre dos personajes usando Programación Orientada a Objetos (POO) y aplicar al menos dos patrones de diseño. Cada personaje tiene una cantidad de puntos de vida (HP) y puede atacar al oponente con un ataque que quite entre 10 y 30 puntos de vida. El juego es por turnos y termina cuando uno de los personajes pierde toda su vida.
Se aplicaron los siguientes patrones de diseño:
- Patrón Strategy: para representar distintas estrategias de ataque.
- Patrón Memento: para guardar y restaurar el estado del juego (vidas de los personajes).
  
# Diagrama
![Juego de lucha](https://github.com/user-attachments/assets/7bd4b87e-f443-4bc6-b460-02acb4764c3d)

# Explicación Paso a Paso
   
# Clases y Métodos

La clase PersonajeBase es abstracta y contiene los atributos y comportamientos comunes a todos los personajes:
- nombre: nombre del personaje.
- puntosDeVida: puntos de vida actuales.
- estrategia: define cómo se calcula el daño del ataque.
  
# Clase PersonajeBase y Subclases

Subclases concretas como Guerrero, Mago y Asesino extienden de PersonajeBase e implementan el método habilidadEspecial(), que agrega una característica única por tipo:
- Guerrero: aumenta el daño mínimo del siguiente ataque.
- Mago: se cura una cantidad aleatoria de vida.
- Asesino: cambia la estrategia para hacer daño crítico.
  
# Métodos principales:

- atacar(Personaje oponente): usa la estrategia de ataque para calcular el daño y lo aplica al oponente.
- estaVivo(): retorna true si los puntos de vida son mayores a 0.
- getNombre() y getPuntosDeVida(): devuelven el nombre y puntos de vida del personaje, respectivamente.
  
# Clase JuegoLucha y Flujo del Juego

La clase JuegoLucha controla el flujo de la pelea:
- En el método iniciarPelea(), se ejecutan turnos alternados entre los dos jugadores mientras ambos estén vivos.
- Antes de cada turno, se guarda el estado actual de los personajes usando el patrón Memento.
- Cada jugador elige el tipo de ataque (Strategy) y decide si quiere activar su habilidad especial.
- Luego se ejecuta el ataque y se actualizan los puntos de vida del oponente.
  
# Condicionales y Ciclos

- Se utiliza un ciclo while para mantener la pelea activa mientras ambos personajes estén vivos.
- Se usan condicionales para determinar:
- Cuál jugador sigue con vida.
- Qué tipo de ataque usar.
- Si se debe aplicar una habilidad especial.
- Quién gana la pelea.
    
# Patrones de Diseño

# Patrón Strategy
El patrón Strategy permite definir una familia de algoritmos (por ejemplo, distintos tipos de ataques), encapsularlos y hacerlos intercambiables. Esto significa que puedes cambiar el algoritmo (estrategia) que usa un objeto en tiempo de ejecución sin modificar su clase. Beneficio:

Aplicación en el juego:
En el juego, este patrón se utiliza para que los personajes puedan cambiar su tipo de ataque durante la pelea. Se crea una interfaz llamada EstrategiaAtaque con el método calcularDano(), y tres clases que la implementan:
•	AtaqueAleatorio: daño entre 10 y 30.
•	AtaqueFijo: daño fijo de 20.
•	AtaqueCritico: daño entre 30 y 40.

# Patrón Memento
Propósito: Guardar y restaurar el estado interno de un objeto sin violar su encapsulamiento.
Aplicación en el juego:
Antes de cada turno, se guarda el estado de los puntos de vida de ambos personajes usando un objeto Memento. Estos estados se almacenan en un Cuidador (Caretaker). Si fuera necesario, se puede restaurar el estado anterior de la pelea (por ejemplo, en caso de un "deshacer" o una habilidad que rebobine el turno).

Beneficio:
- Permite implementar una funcionalidad de restauración de estado (como un retroceso de turno).
- Mejora la experiencia del juego y la seguridad del flujo del combate.
  
el patrón Memento se usa para guardar el estado de vida de ambos personajes antes de cada turno.
Se implementan tres clases:

•	Memento: almacena los puntos de vida del jugador 1 y jugador 2.
•	Cuidador: guarda un historial (pila) de objetos Memento.
•	JuegoLucha: invoca los métodos guardarEstado() y restaurarEstado() para guardar o cargar el estado de la pelea.

# Conclusión
   
El desarrollo del proyecto "Juego de Lucha en Java" ha permitido aplicar de manera efectiva los principios fundamentales de la Programación Orientada a Objetos (POO), así como el uso práctico de patrones de diseño de software, los cuales son herramientas esenciales en la ingeniería de software moderna.
Mediante el uso del patrón Strategy, se logró encapsular distintas formas de ataque, permitiendo que los personajes puedan cambiar su comportamiento dinámicamente durante la ejecución del juego. Esto favorece la extensibilidad del sistema y promueve el principio de abierto/cerrado del paradigma POO.
Por otro lado, la implementación del patrón Memento permitió incorporar una funcionalidad de guardado de estado, la cual puede escalar fácilmente para añadir opciones como deshacer turnos, guardar partidas o gestionar versiones del combate. Este patrón refuerza la separación de responsabilidades y mejora la robustez del código al permitir la restauración del estado sin violar el encapsulamiento de las clases.
Además, la estructura del código fue diseñada con base en la herencia, lo que facilitó la creación de personajes especializados (Guerrero, Mago, Asesino), cada uno con habilidades particulares. Esto demuestra un correcto uso del polimorfismo y la abstracción, pilares fundamentales en el diseño de sistemas orientados a objetos.



