package actividad1;

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

    public void ejecutarPaso (PasoReceta paso) {
        Recipiente recipiente = paso.getRecipiente();
        System.out.println(nombre + " empieza: " + paso.getDescripcion());

        for (int i = 0; i < paso.getIngredientes().size(); i++) {
            recipiente.añadirIngrediente(paso.getIngredientes().get(i));
        }
        recipiente.setEstado("en uso");
        System.out.println("   " + recipiente);
    }
}
