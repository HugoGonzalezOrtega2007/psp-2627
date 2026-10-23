package actividad2;

public class Impresora extends Thread {
    public Impresora(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + getName() + "] -- Imprimiendo página número: " + i);
            pausa(300);
        }
        System.out.println("La " + getName() + " ha acabado.");
    }

    private static void pausa(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
