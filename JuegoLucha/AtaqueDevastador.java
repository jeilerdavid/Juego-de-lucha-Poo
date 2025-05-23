public class AtaqueDevastador implements HabilidadEspecial {
    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        System.out.println(usuario.getNombre() + " usa Ataque Devastador!");
        objetivo.recibirDanio(40);
    }
}
