package actividad5;

public class Trozo implements Runnable {
    final int id;
    final int desde;
    final int hasta;
    final long[] parcial;

    public Trozo(int id, int desde, int hasta) {
        this.id = id;
        this.desde = desde;
        this.hasta = hasta;
        this.parcial = new long[hasta - desde + 1];
    }

    public void run() {
        try {
            System.out.println("[hilo-" + this.id + "] Empieza las tareas " + this.desde + " - " + this.hasta);

            for(int numero = this.desde; numero <= this.hasta; ++numero) {
                this.parcial[numero - this.desde] = Tarea.ejecutar(numero);
            }

            System.out.println("[hilo-" + this.id + "] Tramo listo");
        } catch (InterruptedException var2) {
            Thread.currentThread().interrupt();
            System.out.println("[hilo-" + this.id + "] Me interrumpieron");
        }

    }
}
