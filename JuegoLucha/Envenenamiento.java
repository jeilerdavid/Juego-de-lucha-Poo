public class Envenenamiento implements HabilidadEspecial {
    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        objetivo.aplicarVeneno();
        System.out.println(usuario.getNombre() + " envenenó a " + objetivo.getNombre());
    }
}
