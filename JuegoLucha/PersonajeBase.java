abstract class PersonajeBase {
    protected String nombre;
    protected int puntosDeVida;
    protected EstrategiaAtaque estrategia;

    public PersonajeBase(String nombre, EstrategiaAtaque estrategia) {
        this.nombre = nombre;
        this.puntosDeVida = 100;
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaAtaque estrategia) {
        this.estrategia = estrategia;
    }

    public abstract void habilidadEspecial();

    public void atacar(PersonajeBase oponente) {
        int dano = estrategia.calcularDano();
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }

    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) this.puntosDeVida = 0;
    }

    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }

    public void setPuntosDeVida(int vida) {
        this.puntosDeVida = vida;
    }
}