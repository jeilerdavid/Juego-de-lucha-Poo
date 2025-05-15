import java.util.Random;

class Asesino extends PersonajeBase {
    public Asesino(String nombre) {
        super(nombre, new AtaqueCritico());
    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " activa Golpe Sombra (próximo ataque puede hacer crítico)");
        this.estrategia = () -> new Random().nextInt(51) + 10;
    }
}