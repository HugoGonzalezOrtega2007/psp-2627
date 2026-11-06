package actividad6;

public class Trabajador {
    public static void main(String[] args) throws Exception {
        int ultimaTarea = 0;
        boolean seguir = true;

        while (seguir) {
            Mensaje mensaje = Canal.recibir();

            if (mensaje != null) {
                if (mensaje.esFin()) {
                    System.out.println("Trabajador: fin recibido");
                    seguir = false;
                } else if (mensaje.esEjecuta()) {
                    if (mensaje.tarea != ultimaTarea) {
                        ultimaTarea = mensaje.tarea;
                        System.out.println("Trabajador: trabajando en la tarea " + mensaje.tarea);
                        Canal.enviar(Mensaje.trabajando(mensaje.tarea));

                        Thread.sleep(Canal.ANTES_DE_CONTESTAR_MS);

                        long resultado = mensaje.tarea * 3L;
                        Canal.enviar(Mensaje.completa(mensaje.tarea, resultado));
                        System.out.println("Trabajador: enviado resultado " + resultado);
                    }
                }
            }

            Thread.sleep(Canal.PAUSA_MS);
        }
    }
}