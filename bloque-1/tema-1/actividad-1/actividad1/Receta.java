package actividad1;

import java.util.List;

public class Receta {

    private String nombre;
    private List<PasoReceta> pasos;

    public Receta(String nombre, List<PasoReceta> pasos) {
        this.nombre = nombre;
        this.pasos = pasos;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PasoReceta> getPasos() {
        return pasos;
    }
    public void setPasos(List<PasoReceta> pasos) {
        this.pasos = pasos;
    }

    public void ejecutar(Cocinero cocinero) {
        System.out.println("=== PREPARANDO: " + nombre + " ===\n");
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < pasos.size(); i++) {
            cocinero.ejecutarPaso(pasos.get(i));
        }

        for (int i = 0; i < pasos.size(); i++) {
            pasos.get(i).getRecipiente().setEstado("TERMINADO");
        }

        long fin = System.currentTimeMillis();
        System.out.println("=== RECETA TERMINADA: " + nombre + " ===");
        System.out.println("TIEMPO TOTAL: " + (fin - inicio) / 1000.0 + " s");
    }
}