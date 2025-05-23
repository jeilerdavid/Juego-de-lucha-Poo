import java.util.Random;

public class Curacion implements HabilidadEspecial {
    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        Random rand = new Random();
        int curacion = rand.nextInt(11) + 10; // 10 a 20
        usuario.curar(curacion);
        System.out.println(usuario.getNombre() + " se curó " + curacion + " puntos de vida.");
    }
}
