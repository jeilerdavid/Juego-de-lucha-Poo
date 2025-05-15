import java.util.Random;

class AtaqueAleatorio implements EstrategiaAtaque {
    public int calcularDano() {
        return new Random().nextInt(21) + 10;
    }
}