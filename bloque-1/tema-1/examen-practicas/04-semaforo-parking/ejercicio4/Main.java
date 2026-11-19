package ejercicio4;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        notify1(false);
        notify1(true);
    }

    private static void notify1 (boolean notifyAll) throws InterruptedException {
        System.out.println("NOTIFY A UN COCHE");
        Semaforo semaforo = new Semaforo();
        Operario operario = new Operario(notifyAll, semaforo);

        Coche coche1 = new Coche(semaforo, "Coche 1");
        Coche coche2 = new Coche(semaforo, "Coche 2");
        Coche coche3 = new Coche(semaforo, "Coche 3");

        Thread thread1 = new Thread(coche1, "coche-1");
        Thread thread2 = new Thread(coche2, "coche-2");
        Thread thread3 = new Thread(coche3, "coche-3");

        Thread threadOperario = new Thread(operario,"Hugo");

        thread1.start();
        thread2.start();
        thread3.start();
        threadOperario.start();

        thread1.join();
        thread2.join();
        thread3.join();
        threadOperario.join();

        System.out.println("");
        System.out.println("");
    }
}
