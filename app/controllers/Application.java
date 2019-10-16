package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller{ // implements Sesion {

    public static void index() {

        render();
    }
    public static void inicializarBD(){
        Ingrediente dos2 = new Ingrediente("Lentejas pardina");
        dos2.save();
        Ingrediente uno1 = new Ingrediente("Pimiento Verde");
        uno1.save();

        Receta rec1 = new Receta("Lentejas a la aragonesa");
        rec1.save();
        Receta rec2 = new Receta("Piperrada");
        rec2.save();

        rec1.ingredientes = uno1;
        rec1.save();
        rec1.ingredientes = dos2;
        rec1.save();
        rec2.ingredientes =uno1;
        rec2.save();

    }

        @Override
    public void hacerMenu() {

    }

    @Override
    public String masRecetas() {
        return null;
    }

    @Override
    public void verIngredientes() {
        //OPCIONES POR ORDEN DE DIFICULTAD
        // 1 Ves una receta y te muestra sus ingredientes
        // 2 Busca las recetas que contienen un ingrediente

    }

    public void addIngrediente(){

    }

    public void addReceta(){

    }

}