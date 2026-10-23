package NoSincronizacion;

import e02.Incrementador;

public class Main {

    private static final int INCREMENTOS_POR_HILO = 1000;

    public static void main (String[] args) throws InterruptedException {

        Aforo aforo = new Aforo();

        Thread a = new Thread(new Visitante(aforo, INCREMENTOS_POR_HILO), "hilo-A");
        Thread b = new Thread(new Visitante(aforo, INCREMENTOS_POR_HILO), "hilo-B");
        Thread c = new Thread(new Visitante(aforo, INCREMENTOS_POR_HILO), "hilo-C");
        Thread d = new Thread(new Visitante(aforo, INCREMENTOS_POR_HILO), "hilo-D");

        System.out.println("Cuatro hilos de " + INCREMENTOS_POR_HILO + ". El esperado "
                + (4 * INCREMENTOS_POR_HILO));

        a.start();
        b.start();
        c.start();
        d.start();
        a.join();
        b.join();
        c.join();
        d.join();

        System.out.println("Resultado: " + aforo.getValor());
    }
}
