package actividad1;

import java.time.LocalTime;

public class Cocinero {
    private String nombre;

    public Cocinero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void ejecutarPaso(PasoReceta paso) {
        Recipiente recipiente = paso.getRecipiente();

        System.out.println(LocalTime.now() + " | " + nombre + " empieza: " + paso.getDescripcion());
        System.out.println("   Recipiente: " + recipiente.getNombre());

        String textoIngredientes = "";
        if (paso.getIngredientes().isEmpty()) {
            textoIngredientes = "ninguno";
        } else {
            for (int i = 0; i < paso.getIngredientes().size(); i++) {
                textoIngredientes += paso.getIngredientes().get(i);
                if (i < paso.getIngredientes().size() - 1) {
                    textoIngredientes += ", ";
                }
            }
        }
        System.out.println("   Ingredientes: " + textoIngredientes);

        System.out.println("   Duración simulada: " + paso.getDuracion() + " s");

        for (int i = 0; i < paso.getIngredientes().size(); i++) {
            recipiente.añadirIngrediente(paso.getIngredientes().get(i));
        }
        recipiente.setEstado("en uso");
        System.out.println("   Contenido: " + recipiente);

        try {
            Thread.sleep(paso.getDuracion() * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Paso interrumpido");
        }

        System.out.println(LocalTime.now() + " | " + nombre + " termina: " + paso.getDescripcion());
        System.out.println();
    }
}