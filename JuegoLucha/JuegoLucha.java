import java.util.Scanner;

public class JuegoLucha {
    private PersonajeBase jugador1;
    private PersonajeBase jugador2;
    private Cuidador cuidador;

    public JuegoLucha(PersonajeBase jugador1, PersonajeBase jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.cuidador = new Cuidador();
    }

    public void iniciarPelea() {
        System.out.println("¡La pelea comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "!");

        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            guardarEstado();
            turno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                guardarEstado();
                turno(jugador2, jugador1);
            }
        }

        System.out.println(jugador1.estaVivo() ? jugador1.getNombre() + " ha ganado." : jugador2.getNombre() + " ha ganado.");
    }

    private void turno(PersonajeBase atacante, PersonajeBase defensor) {
        System.out.println("\nTurno de " + atacante.getNombre());
        System.out.println(defensor.getNombre() + " tiene " + defensor.getPuntosDeVida() + " puntos de vida.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un tipo de ataque:");
        System.out.println("1. Ataque Aleatorio (10-30)");
        System.out.println("2. Ataque Fijo (20)");
        System.out.println("3. Ataque Crítico (30-40)");

        int opcion = 0;
        while (opcion < 1 || opcion > 3) {
            System.out.print("Opción (1-3): ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }
        }

        switch (opcion) {
            case 1 -> atacante.setEstrategia(new AtaqueAleatorio());
            case 2 -> atacante.setEstrategia(new AtaqueFijo());
            case 3 -> atacante.setEstrategia(new AtaqueCritico());
        }

        System.out.print("¿Deseas usar tu habilidad especial este turno? (s/n): ");
        String usar = scanner.nextLine().trim().toLowerCase();
        if (usar.equals("s")) {
            atacante.habilidadEspecial();
        }

        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " puntos de vida.");
    }

    private void guardarEstado() {
        Memento m = new Memento(jugador1.getPuntosDeVida(), jugador2.getPuntosDeVida());
        cuidador.guardarEstado(m);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipos de personaje: 1-Guerrero  2-Mago  3-Asesino");

        System.out.print("Jugador 1 - nombre: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Tipo (1/2/3): ");
        int tipo1 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Jugador 2 - nombre: ");
        String nombre2 = scanner.nextLine();
        System.out.print("Tipo (1/2/3): ");
        int tipo2 = scanner.nextInt();

        PersonajeBase p1 = crearPersonaje(nombre1, tipo1);
        PersonajeBase p2 = crearPersonaje(nombre2, tipo2);

        JuegoLucha juego = new JuegoLucha(p1, p2);
        juego.iniciarPelea();
    }

    private static PersonajeBase crearPersonaje(String nombre, int tipo) {
        return switch (tipo) {
            case 1 -> new Guerrero(nombre);
            case 2 -> new Mago(nombre);
            case 3 -> new Asesino(nombre);
            default -> new Guerrero(nombre);
        };
    }
}