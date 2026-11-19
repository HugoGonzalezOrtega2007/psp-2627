package ejercicio4;

public class Coche implements Runnable {
    private final String nombre;
    Semaforo semaforo;

    public Coche(Semaforo semaforo, String nombre) {
        this.semaforo = semaforo;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            semaforo.esperarVerde();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El coche " + nombre + " ha arrancado.");
    }
}
