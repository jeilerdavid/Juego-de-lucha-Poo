import java.util.Random;

class Guerrero extends PersonajeBase {
    public Guerrero(String nombre) {
        super(nombre, new AtaqueAleatorio());
    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " usa Furia del Guerrero (+10 de daño en el próximo ataque)");
        this.estrategia = () -> new Random().nextInt(21) + 20;
    }
}