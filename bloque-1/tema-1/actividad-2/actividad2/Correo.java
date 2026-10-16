package actividad2;

public class Correo implements Runnable {
    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + nombre + "] -- Revisando el mensaje número: " + i);
            pausa(500);
        }
        System.out.println("El " + nombre + " ha acabado.");
    }

    private static void pausa(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
