package actividad6;

public class Main {
    public static void main(String[] args) throws Exception {
        long[] resultados = new long[9];
        long suma = 0;

        for (int i = 1; i <= 8; i++) {
            Canal.enviar(Mensaje.ejecuta(i));
            System.out.println("Jefe: enviada la tarea " + i);

            boolean terminado = false;
            while (!terminado) {
                Mensaje mensaje = Canal.recibir();
                if (mensaje != null) {
                    if (mensaje.esCompleta()) {
                        if (mensaje.tarea == i) {
                            resultados[i] = mensaje.resultado;
                            suma += mensaje.resultado;
                            System.out.println("Main: resultado de la tarea " + i + " = " + mensaje.resultado);
                            terminado = true;
                        }
                    }
                }
                Thread.sleep(Canal.PAUSA_MS);
            }

            Thread.sleep(Canal.ANTES_DE_CONTESTAR_MS);
        }

        Canal.enviar(Mensaje.fin());

        for (int i = 1; i <= 8; i++) {
            System.out.println("Tarea " + i + ": " + resultados[i]);
        }
        System.out.println("Suma: " + suma);
    }
}