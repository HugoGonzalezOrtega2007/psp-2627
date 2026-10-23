package actividad4;

public class Alumno implements Runnable {
    private final Recreo recreo;
    private final String alumno;

    public Alumno(Recreo recreo, String alumno) {
        this.recreo = recreo;
        this.alumno = alumno;
    }

    @Override
    public void run() {
        try {
            recreo.esperarTimbre(alumno);
            System.out.println(alumno + " sale al recreo.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
