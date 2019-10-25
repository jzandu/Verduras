package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller{
    public static void index() {
        inicializarBD();
        render();
    }
    public static void inicializarBD(){

        addIngrediente("Pimiento Verde");
        Ingrediente dos2 = new Ingrediente("Lentejas pardina").save();

        Receta rec1 = new Receta("Lentejas a la aragonesa", "Cocer las lentejas").save();
        Receta rec2 = new Receta("Piperrada", "Cortar los pimientos").save();

        IngRec relacio1 = new IngRec(dos2,200,rec1).save();


    }


    public void hacerMenu() {

    }

    public String masRecetas() {
        return null;
    }

    public void verIngredientes() {
        //OPCIONES POR ORDEN DE DIFICULTAD
        // 1 Ves una receta y te muestra sus ingredientes
        // 2 Busca las recetas que contienen un ingrediente

    }

    public static Ingrediente addIngrediente(String nombre){
        return new Ingrediente(nombre).save();
    }

    public void addReceta(){

    }

}