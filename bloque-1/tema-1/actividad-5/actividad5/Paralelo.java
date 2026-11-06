package actividad5;

public class Paralelo {

    public static void main(String[] args) throws InterruptedException {
        long[] resultados = new long[Tarea.TOTAL];
        Trozo[] trozos = new Trozo[Tarea.HILOS];
        Thread[] hilos = new Thread[Tarea.HILOS];
        System.out.println("Paralelo -- Hilo: " + Thread.currentThread().getName());
        System.out.println(Tarea.HILOS + " hilos, " + Tarea.POR_HILO + " pedidos, " + Tarea.DURACION_MS + " ms");
        System.out.println("Tiempo esperado: unos 2,5s");
        System.out.println("---");
        long inicio = System.nanoTime();

        for (int h = 0; h < Tarea.HILOS; h++) {
            int desde = h * Tarea.POR_HILO + 1;
            int hasta = desde + Tarea.POR_HILO - 1;
            trozos[h] = new Trozo(h + 1, desde, hasta);
            hilos[h] = new Thread(trozos[h], "hilo-" + (h + 1));
            hilos[h].start();
        }

        for (int h = 0; h < hilos.length; h++) {
            hilos[h].join();
        }

        for (int h = 0; h < trozos.length; h++) {
            guardar(resultados, trozos[h]);
        }

        long ms = (System.nanoTime() - inicio) / 1_000_000L;
        Secuencial.informar(resultados, ms);
    }

    private static void guardar(long[] resultados, Trozo trozo) {
        for (int i = 0; i < trozo.parcial.length; i++) {
            resultados[trozo.desde - 1 + i] = trozo.parcial[i];
        }
        System.out.println("Tramo " + trozo.desde + " - " + trozo.hasta);
    }
}