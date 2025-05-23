public class IncrementoAtaque implements HabilidadEspecial {
    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        usuario.incrementarAtaque();
        System.out.println(usuario.getNombre() + " incrementó su ataque un 10%.");
    }
}
