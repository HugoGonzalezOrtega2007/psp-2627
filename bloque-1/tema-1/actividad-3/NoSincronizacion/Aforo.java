package NoSincronizacion;

public class Aforo {
    private int valor = 0;

    public void incrementar() {
        int actual = valor;
        valor = actual + 1;
    }

    public int getValor() {
        return valor;
    }
}
