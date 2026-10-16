package Sincronizacion;

public class Visitante implements Runnable{
    private Aforo aforo;
    private final int veces;

    public Visitante (Aforo aforo, int veces) {
        this.aforo = aforo;
        this.veces = veces;
    }

    @Override
    public void run() {
        for (int i = 0; i < veces; i++) {
            aforo.incrementar();
        }
    }
}
