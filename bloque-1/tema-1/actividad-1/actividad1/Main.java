package actividad1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Recipiente olla = new Recipiente("olla");
        Recipiente sarten = new Recipiente("sartén");
        Recipiente colador = new Recipiente("colador");
        Recipiente plato = new Recipiente("plato");

        Ingrediente agua = new Ingrediente(2, "agua", "L");
        Ingrediente sal = new Ingrediente(5, "sal", "g");
        Ingrediente espaguetis = new Ingrediente(100, "espaguetis", "g");
        Ingrediente aceite = new Ingrediente(20, "aceite", "ml");
        Ingrediente cebolla = new Ingrediente(1, "cebolla", "unidad");
        Ingrediente ajo = new Ingrediente(2, "ajo", "dientes");
        Ingrediente carne = new Ingrediente(200, "carne picada", "g");
        Ingrediente tomate = new Ingrediente(400, "tomate", "g");

        List<Ingrediente> ingAgua = new ArrayList<>();
        ingAgua.add(agua);
        ingAgua.add(sal);
        List<Ingrediente> ingPasta = new ArrayList<>();
        ingPasta.add(espaguetis);
        List<Ingrediente> ingSofrito = new ArrayList<>();
        ingSofrito.add(cebolla);
        ingSofrito.add(ajo);
        ingSofrito.add(aceite);
        List<Ingrediente> ingCarne = new ArrayList<>();
        ingCarne.add(carne);
        List<Ingrediente> ingTomate = new ArrayList<>();
        ingTomate.add(tomate);
        List<Ingrediente> ninguno = new ArrayList<>();
        List<PasoReceta> pasos = new ArrayList<>();

        pasos.add(new PasoReceta("Poner agua a hervir en la olla", 3, ingAgua, olla));
        pasos.add(new PasoReceta("Cocer los espaguetis en la olla", 5, ingPasta, olla));
        pasos.add(new PasoReceta("Sofreír la cebolla y el ajo con aceite", 4, ingSofrito, sarten));
        pasos.add(new PasoReceta("Añadir la carne picada y dorarla", 6, ingCarne, sarten));
        pasos.add(new PasoReceta("Añadir el tomate y dejar reducir la salsa", 7, ingTomate, sarten));
        pasos.add(new PasoReceta("Escurrir la pasta", 2, ninguno, colador));
        pasos.add(new PasoReceta("Mezclar la pasta con la salsa boloñesa", 3, ninguno, sarten));
        pasos.add(new PasoReceta("Emplatar", 1, ninguno, plato));

        Receta receta = new Receta("Espaguetis a la boloñesa", pasos);
        Cocinero cocinero = new Cocinero("Pepe");
        receta.ejecutar(cocinero);
    }
}