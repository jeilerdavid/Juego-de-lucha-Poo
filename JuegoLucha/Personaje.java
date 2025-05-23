public class Personaje {
    private String nombre;
    private int vida;
    private double multiplicadorAtaque;
    private boolean defensaActiva;
    private int acumulacionVeneno;
    private HabilidadEspecial habilidadEspecial;

    public Personaje(String nombre, HabilidadEspecial habilidadEspecial) {
        this.nombre = nombre;
        this.vida = 100;
        this.multiplicadorAtaque = 1.0;
        this.defensaActiva = false;
        this.acumulacionVeneno = 0;
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDanio(int cantidad) {
        if (defensaActiva) cantidad /= 2;
        vida -= cantidad;
        if (vida < 0) vida = 0;
        defensaActiva = false; // solo dura un turno
    }

    public void curar(int cantidad) {
        vida += cantidad;
        if (vida > 100) vida = 100;
    }

    public void atacarNormal(Personaje oponente) {
        int danio = (int) (10 * multiplicadorAtaque);
        System.out.println(nombre + " realiza un ataque normal causando " + danio + " de daño.");
        oponente.recibirDanio(danio);
        oponente.aplicarVenenoTurno();
    }

    public void atacarCritico(Personaje oponente) {
        int danio = (int) (20 * multiplicadorAtaque);
        System.out.println(nombre + " realiza un ataque crítico causando " + danio + " de daño.");
        oponente.recibirDanio(danio);
        oponente.aplicarVenenoTurno();
    }

    public void usarHabilidadEspecial(Personaje oponente) {
        if (habilidadEspecial != null) {
            habilidadEspecial.usar(this, oponente);
        }
    }

    public void incrementarAtaque() {
        if (multiplicadorAtaque < 1.2) {
            multiplicadorAtaque += 0.1;
        }
    }

    public void activarDefensa() {
        defensaActiva = true;
    }

    public void aplicarVeneno() {
        if (acumulacionVeneno < 2) {
            acumulacionVeneno++;
        }
    }

    public void aplicarVenenoTurno() {
        if (acumulacionVeneno > 0) {
            int danio = (int) (vida * 0.05 * acumulacionVeneno);
            System.out.println(nombre + " sufre " + danio + " de daño por veneno.");
            recibirDanio(danio);
        }
    }
}
