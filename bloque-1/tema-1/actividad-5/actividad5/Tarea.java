package actividad5;

public class Tarea {
    public static final int TOTAL = 800;
    public static final int HILOS = 8;
    public static final int POR_HILO = 100;
    public static final long DURACION_MS = 25L;

    private Tarea() {
    }

    public static long ejecutar(int numero) throws InterruptedException {
        Thread.sleep(DURACION_MS);
        return 1L;
    }

    public static long suma(long[] resultados) {
        long total = 0L;

        for (long resultado : resultados) {
            total += resultado;
        }

        return total;
    }

    public static long sumaEsperada() {
        return TOTAL;
    }
}

