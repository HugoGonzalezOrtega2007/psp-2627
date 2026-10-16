package actividad2;

public class Backup extends Thread {
    public Backup(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + getName() + "] -- Copiando página número: " + i);
            pausa(400);
        }
        System.out.println("El " + getName() + " ha acabado.");
    }

    private static void pausa(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}