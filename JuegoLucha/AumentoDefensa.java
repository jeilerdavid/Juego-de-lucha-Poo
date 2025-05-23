public class AumentoDefensa implements HabilidadEspecial {
    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        usuario.activarDefensa();
        System.out.println(usuario.getNombre() + " activó aumento de defensa.");
    }
}
