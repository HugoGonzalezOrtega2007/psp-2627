package ejercicio4;

public class Operario implements Runnable {
    private String nombre = "Hugo";
    Semaforo semaforo;
    private boolean notifyAll;

    public Operario(boolean notifyAll, Semaforo semaforo) {
        this.notifyAll = notifyAll;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (notifyAll) {
            System.out.println("Llamando a todos los coches.");
            semaforo.ponerVerdeConNotifyAll();
            System.out.println("Notify a todos realizado.");
        } else {
            System.out.println("Llamando a un coche.");
            semaforo.ponerVerdeConNotify();
            System.out.println("Notify realizado.");
            System.out.println("Llamando al resto");
            semaforo.ponerVerdeConNotifyAll();
        }
    }
}
