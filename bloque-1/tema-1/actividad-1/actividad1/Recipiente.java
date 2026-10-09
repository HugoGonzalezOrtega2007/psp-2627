package actividad1;

import java.util.List;

public class Recipiente {

    private String nombre;
    private String estado;
    private List<Ingrediente> ingredientes;

    public Recipiente( String nombre) {
        this.estado = "vacio";
        this.ingredientes = 0;
        this.nombre = nombre;
    }

    public void añadirIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return nombre + " [" + estado + "] contiene: " + ingredientes;
    }
}