package actividad1;

import java.util.List;

public class PasoReceta {

    private String descripcion;
    private int duracion;
    private Recipiente recipiente;
    private List<Ingrediente> ingredientes;

    public PasoReceta(String descripcion, int duracion, List<Ingrediente> ingredientes, Recipiente recipiente) {
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.ingredientes = ingredientes;
        this.recipiente = recipiente;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Recipiente getRecipiente() {
        return recipiente;
    }
    public void setRecipiente(Recipiente recipiente) {
        this.recipiente = recipiente;
    }

    @Override
    public String toString() {
        return descripcion + " (recipiente: " + recipiente.getNombre() + ", ingredientes: " + ingredientes + ", duración: " + duracion + "s)";
    }
}
