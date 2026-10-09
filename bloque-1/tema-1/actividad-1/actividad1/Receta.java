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
        System.out.println("Preparando: " + nombre);
        for (int i = 0; i < pasos.size(); i++) {
            PasoReceta paso = pasos.get(i);
            cocinero.ejecutarPaso(paso);
        }
        System.out.println("Receta terminada: " + nombre);
    }
}