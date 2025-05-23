# Juego de Lucha Poo
Estudiante: Jeiler David Medina Zapata, Juan Camilo Contreras Ambuila 

Curso:Ingeniería de Software II

Docente:  Jhon Haide Cano Beltrán MSc

Fecha: 14 de mayo de 2025

# Enunciado

El objetivo del proyecto es desarrollar un juego de lucha entre dos personajes usando Programación Orientada a Objetos (POO) y aplicar al menos dos patrones de diseño. Cada personaje tiene una cantidad de puntos de vida (HP) y puede atacar al oponente con diferentes tipos de ataque. El juego es por turnos y termina cuando uno de los personajes pierde toda su vida. Se aplicaron los siguientes patrones de diseño:

Patrón Strategy: para representar distintas estrategias de ataque.

Patrón Memento: para guardar y restaurar el estado del juego (vidas de los personajes).

# Diagrama
![juegolucha3 0 drawio](https://github.com/user-attachments/assets/f0c9d759-c20b-4ece-8bd6-562dc8567ace)


# Explicación Paso a Paso

# Clases y Métodos

Clase Personaje

Contiene atributos y comportamientos comunes:

. nombre: nombre personalizado del personaje.

. puntosDeVida: puntos de vida actuales.

. estrategia: define cómo se calcula el daño del ataque.

. habilidadEspecial: objeto que representa la habilidad especial del personaje (una de cinco disponibles).

# Métodos principales

. atacarNormal(oponente): usa la estrategia de ataque normal.

. atacarCritico(oponente): usa la estrategia de ataque crítico.

. usarHabilidadEspecial(oponente): aplica la habilidad especial elegida al momento de crear el personaje.

. estaVivo(): retorna true si los puntos de vida son mayores a 0.

. getNombre() y getPuntosDeVida()

# Habilidades Especiales

. AtaqueDevastador: 40 puntos de daño al oponente.

. Curacion: recupera entre 10 y 20 puntos de vida.

. IncrementoAtaque: incrementa el daño normal y crítico en un 10% (hasta 2 veces).

. AumentoDefensa: reduce a la mitad el daño recibido mientras está activo.

. Envenenamiento: el enemigo pierde 5% de vida por turno (acumulable hasta 2 veces).

Cada personaje elige una única habilidad especial al momento de su creación.


# Clase JuegoLucha y Flujo del Juego

La clase JuegoLucha controla el flujo completo:

1. Solicita nombres de jugadores 1 y 2.

2. Permite que cada jugador cree su personaje con:

   .Nombre del personaje.

   .Selección de una habilidad especial.

3. Comienza la pelea por turnos alternados:

   .Se guarda el estado de la pelea antes de cada turno con Memento.

   .Cada jugador elige si ataca normal, crítico o usa su habilidad especial.

   .Se aplican los efectos de daño, curación o estados.

4. Se determina al ganador cuando uno de los personajes pierde toda la vida.


# Condicionales y Ciclos

.Se usa un bucle while para mantener la pelea activa mientras ambos personajes estén vivos.

.Se usan condicionales para decidir:

  .Qué tipo de ataque ejecutar.

  .Si se debe usar la habilidad especial.

  .Si el efecto acumulativo (envenenamiento o incremento de ataque) se debe aplicar.


# Patrones de Diseño Aplicados

# Patrón Strategy

Propósito: encapsular comportamientos de ataque y hacerlos intercambiables.

# Aplicación:

AtaqueNormal: daño entre 10 y 20 puntos.

AtaqueCritico: daño entre 20 y 35 puntos.

Beneficio: permite al personaje usar distintas estrategias de ataque durante la pelea sin modificar su estructura.

# Patrón Memento

Propósito: guardar y restaurar el estado interno del juego.

Aplicación:

Memento: almacena los puntos de vida actuales de los personajes.

Cuidador: administra el historial de estados.

JuegoLucha: guarda/restaura estados antes de cada turno.

Beneficio: habilita el retroceso de turnos o deshacer acciones futuras.


# Conclusión

El desarrollo del proyecto "Juego de Lucha en Java" demuestra una aplicación efectiva de los principios fundamentales de la POO, como encapsulamiento, polimorfismo y herencia, junto con patrones de diseño. La eliminación de clases innecesarias como PersonajeFactory y subclases específicas (Guerrero, Mago, Asesino) simplificó la arquitectura del sistema y mejoró su flexibilidad. La introducción de habilidades especiales acumulables y únicas potencia la jugabilidad y personalización, mientras que los patrones Strategy y Memento aseguran un diseño extensible y mantenible. El juego ahora permite una experiencia más dinámica, interactiva y estratégica para el jugador.

