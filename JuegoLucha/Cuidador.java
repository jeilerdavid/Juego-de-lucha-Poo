import java.util.Stack;

class Cuidador {
    private Stack<Memento> historial = new Stack<>();

    public void guardarEstado(Memento m) {
        historial.push(m);
    }

    public Memento restaurarEstado() {
        if (!historial.isEmpty()) {
            return historial.pop();
        }
        return null;
    }
}