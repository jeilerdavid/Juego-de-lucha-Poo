import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bienvenido al Juego de Lucha ===");

        // Ingreso nombres jugadores
        System.out.print("Jugador 1, ingresa tu nombre: ");
        String nombreJugador1 = scanner.nextLine();
        Personaje jugador1 = crearPersonaje(scanner, nombreJugador1);

        System.out.print("Jugador 2, ingresa tu nombre: ");
        String nombreJugador2 = scanner.nextLine();
        Personaje jugador2 = crearPersonaje(scanner, nombreJugador2);

        // Combate
        int turno = 1;
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            System.out.println("\n--- Turno " + turno + " ---");
            System.out.println(jugador1.getNombre() + " HP: " + jugador1.getVida());
            System.out.println(jugador2.getNombre() + " HP: " + jugador2.getVida());

            ejecutarTurno(scanner, jugador1, jugador2);
            if (!jugador2.estaVivo()) break;
            ejecutarTurno(scanner, jugador2, jugador1);

            turno++;
        }

        System.out.println("\n=== Fin del combate ===");
        if (jugador1.estaVivo()) {
            System.out.println(jugador1.getNombre() + " ha ganado.");
        } else {
            System.out.println(jugador2.getNombre() + " ha ganado.");
        }

        scanner.close();
    }

    private static Personaje crearPersonaje(Scanner scanner, String nombreJugador) {
        System.out.print(nombreJugador + ", elige el nombre de tu personaje: ");
        String nombrePersonaje = scanner.nextLine();
        System.out.println("Elige una habilidad especial:");
        System.out.println("1. Ataque Devastador (40 de daño)");
        System.out.println("2. Curación (10-20 HP)");
        System.out.println("3. Incremento de Ataque (+10% acumulable hasta 2 veces)");
        System.out.println("4. Aumento de Defensa (mitad de daño recibido)");
        System.out.println("5. Envenenamiento (5% de vida por turno, acumulable hasta 2 veces)");

        int opcion;
        do {
            System.out.print("Ingresa una opción (1-5): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingresa un número válido (1-5): ");
                scanner.next(); // limpiar entrada no numérica
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
        } while (opcion < 1 || opcion > 5);

        HabilidadEspecial habilidad = switch (opcion) {
            case 1 -> new AtaqueDevastador();
            case 2 -> new Curacion();
            case 3 -> new IncrementoAtaque();
            case 4 -> new AumentoDefensa();
            case 5 -> new Envenenamiento();
            default -> null;
        };

        return new Personaje(nombrePersonaje, habilidad);
    }

    private static void ejecutarTurno(Scanner scanner, Personaje actual, Personaje oponente) {
        System.out.println("\nTurno de " + actual.getNombre());
        System.out.println("1. Ataque normal");
        System.out.println("2. Ataque crítico");
        System.out.println("3. Usar habilidad especial");

        int opcion;
        do {
            System.out.print("Elige una acción (1-3): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingresa un número válido (1-3): ");
                scanner.next();
            }
            opcion = scanner.nextInt();
        } while (opcion < 1 || opcion > 3);

        switch (opcion) {
            case 1 -> actual.atacarNormal(oponente);
            case 2 -> actual.atacarCritico(oponente);
            case 3 -> actual.usarHabilidadEspecial(oponente);
        }
    }
}
