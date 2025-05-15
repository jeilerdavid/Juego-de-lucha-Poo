import java.util.Random;

class Mago extends PersonajeBase {
    public Mago(String nombre) {
        super(nombre, new AtaqueFijo());
    }

    @Override
    public void habilidadEspecial() {
        int curacion = new Random().nextInt(11) + 5;
        this.puntosDeVida += curacion;
        if (this.puntosDeVida > 100) this.puntosDeVida = 100;
        System.out.println(nombre + " lanza Curación Mágica y recupera " + curacion + " puntos de vida.");
    }
}