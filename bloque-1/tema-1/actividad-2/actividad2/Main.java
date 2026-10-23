package actividad2;

import e01.Autoguardado;
import e01.HiloTeclado;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Arranca el proceso. Hilo actual: " + Thread.currentThread().getName());

        Thread impresora = new Impresora("impresora");
        Thread correo = new Thread(new Correo(), "correo");
        Thread backup = new Backup("backup");

        impresora.start();
        correo.start();
        backup.start();
        System.out.println("Hilos lanzados");
        impresora.join();
        correo.join();
        backup.join();

        System.out.println("=== Todos los hilos han terminado ===");
        System.out.println("Fin. Hilo actual: " + Thread.currentThread().getName());
    }
}
