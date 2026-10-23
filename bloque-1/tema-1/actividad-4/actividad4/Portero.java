package actividad4;

public class Portero implements Runnable {
    private final Recreo recreo;
    private final boolean usarNotifyAll;

    public Portero(Recreo recreo, boolean usarNotifyAll) {
        this.recreo = recreo;
        this.usarNotifyAll = usarNotifyAll;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(800);
            System.out.println("\nEl portero llega al timbre.");
            if (usarNotifyAll) {
                recreo.tocarConNotifyAll();
            } else {
                recreo.tocarConNotify();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}