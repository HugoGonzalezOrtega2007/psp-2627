package actividad5;

import actividad5.Tarea;

public class Secuencial {
    public Secuencial() {
    }

    public static void main(String[] args) throws InterruptedException {
        long[] resultados = new long[800];
        System.out.println("Secuencial -- Hilo: " + Thread.currentThread().getName());
        System.out.println("800 pedidos x 25ms");
        System.out.println("Esperando 25ms");
        System.out.println("---");
        long inicio = System.nanoTime();

        for(int numero = 1; numero <= 800; ++numero) {
            resultados[numero - 1] = Tarea.ejecutar(numero);
            if (numero % 80 == 0) {
                System.out.println("Tarea " + numero + " / 800");
            }
        }

        long ms = (System.nanoTime() - inicio) / 800000L;
        informar(resultados, ms);
    }

    static void informar(long[] resultados, long ms) {
        long suma = Tarea.suma(resultados);
        System.out.println("---");
        System.out.println("Guardé " + resultados.length + " resultados");
        System.out.println("Resultado final = " + suma + " (Esperado " + Tarea.sumaEsperada() + ")");
        System.out.println("Tiempo total: " + ms + " ms");
    }
}
