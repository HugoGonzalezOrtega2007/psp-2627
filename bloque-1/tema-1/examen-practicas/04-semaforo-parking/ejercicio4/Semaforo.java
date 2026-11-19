package ejercicio4;

public class Semaforo {
    private boolean verde = false;

    public synchronized void esperarVerde () throws InterruptedException {
        while (!verde) {
            wait();
        }
    }

    public synchronized void ponerVerdeConNotify () {
        verde = true;
        notify();
    }

    public synchronized void ponerVerdeConNotifyAll () {
        verde = true;
        notifyAll();
    }
}
