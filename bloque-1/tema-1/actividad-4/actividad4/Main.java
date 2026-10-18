package actividad4;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        demoNotify();
        demoNotifyAll();
    }

    private static void demoNotify() throws InterruptedException {
        System.out.println("=== DEMO 1: notify() ===");
        Recreo recreo = new Recreo();
        Thread[] alumnos = crearAlumnos(recreo);
        Thread portero = new Thread(new Portero(recreo, false));

        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i].start();
        }
        portero.start();
        portero.join();

        Thread.sleep(1000);
        System.out.println("Alumnos despertados: " + recreo.getDespertados());
        System.out.println("\n--- Limpieza ---");
        recreo.tocarConNotifyAll();

        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i].join();
        }
        System.out.println("Total tras la limpieza: " + recreo.getDespertados());
    }

    private static void demoNotifyAll() throws InterruptedException {
        System.out.println("\n=== DEMO 2: notifyAll() ===");
        Recreo recreo = new Recreo();
        Thread[] alumnos = crearAlumnos(recreo);
        Thread portero = new Thread(new Portero(recreo, true));

        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i].start();
        }
        portero.start();

        portero.join();
        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i].join();
        }
        System.out.println("Alumnos despertados: " + recreo.getDespertados());
    }

    //CREACION DE LOS ALUMNOS
    private static Thread[] crearAlumnos(Recreo recreo) {
        return new Thread[] {
                new Thread(new Alumno(recreo, "Ana")),
                new Thread(new Alumno(recreo, "Luis")),
                new Thread(new Alumno(recreo, "Marta"))
        };
    }
}