import java.util.Random;

class AtaqueCritico implements EstrategiaAtaque {
    public int calcularDano() {
        return new Random().nextInt(11) + 30;
    }
}