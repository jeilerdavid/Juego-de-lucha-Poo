class Memento {
    private final int vidaJugador1;
    private final int vidaJugador2;

    public Memento(int vidaJugador1, int vidaJugador2) {
        this.vidaJugador1 = vidaJugador1;
        this.vidaJugador2 = vidaJugador2;
    }

    public int getVidaJugador1() {
        return vidaJugador1;
    }

    public int getVidaJugador2() {
        return vidaJugador2;
    }
}