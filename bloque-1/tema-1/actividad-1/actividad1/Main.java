package actividad1;

public class Main {
    public static void main(String[] args) {

        PasoReceta[] pasos = new PasoReceta[8];

        Recipiente olla = new Recipiente("olla");
        Recipiente sartén = new Recipiente("sartén");
        Recipiente colador = new Recipiente("colador");
        Recipiente plato = new Recipiente("plato");

        Ingrediente agua = new Ingrediente(2, "agua", "L");
        Ingrediente sal = new Ingrediente(5, "sal", "g");
        Ingrediente aceite = new Ingrediente(30, "aceite", "ml");
        Ingrediente cebolla = new Ingrediente(1, "cebolla", "unidad");
        Ingrediente ajo = new Ingrediente(2, "ajo", "dientes");
        Ingrediente carne = new Ingrediente(250, "carne", "g");
        Ingrediente tomate = new Ingrediente(400, "tomate", "g");
        Ingrediente espaguetis = new Ingrediente(200, "espaguetis", "g");

        pasos[0] = new PasoReceta("Poner agua a hervir en la olla", 10, agua, sal);
        pasos[1] = new PasoReceta("Cocer los espaguetis en la olla.", 20, "espaguetis", "olla");
        pasos[2] = new PasoReceta("Sofreír la cebolla y el ajo en la sartén con aceite.", 30, "cebolla + ajo + aceite", "sartén");

        System.out.println(receta);

    }
}