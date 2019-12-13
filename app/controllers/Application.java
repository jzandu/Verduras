package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import views.*;
import models.*;

public class Application extends Controller{
    public void index() {
        inicializarBD();
        renderText("ASi funciona")
    }
    public void inicializarBD(){

        Ingrediente dos2 = new Ingrediente("Lentejas pardina").save();
        dos2 = new Ingrediente("Pimiento verde").save();
        //addIngrediente("Pimkiento Verde");
        addIngrediente("Pimiento verde");


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

    /*public static Ingrediente addIngrediente(String nombre){

        return new Ingrediente(nombre).save();
    }*/

    public void addIngrediente(String nombre){
        Ingrediente ni = Ingrediente.find("byNom", nombre).first();
        if (ni == null) {
            ni = new Ingrediente(nombre);
            ni.save();
        }

    }
    /*NO hace mas que darme problemas al intentar hacer esta funcion
    puede ser que se por que no ha inicializado la bd??*/

    public void addReceta(){

    }

}