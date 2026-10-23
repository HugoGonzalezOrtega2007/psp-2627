package actividad1;

public class Ingrediente {

    private String nombre;
    private int cantidad;
    private String unidad;

    public Ingrediente(int cantidad, String nombre, String unidad) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.unidad = unidad;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return cantidad + " " + unidad + " de " + nombre;
    }
}
