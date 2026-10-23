package actividad4;

public class Recreo {
    private boolean sonando = false;
    private int despertados = 0;

    public synchronized void esperarTimbre(String alumno) throws InterruptedException {
        while (!sonando) {
            System.out.println(alumno + ": el timbre aún no suena");
            wait();
        }
        despertados++;
        System.out.println(alumno + ": ha sonado el timbre");
    }

    public synchronized void tocarConNotify() {
        sonando = true;
        System.out.println("El portero toca el timbre");
        notify();
    }

    public synchronized void tocarConNotifyAll() {
        sonando = true;
        System.out.println("El portero toca el timbre");
        notifyAll();
    }

    public synchronized int getDespertados() {
        return despertados;
    }
}