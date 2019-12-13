package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import views.*;
import models.*;
import javax.persistence.*;
import play.db.jpa.*;


public class Application extends Controller{
    public void index() {
        String h1 = "select nombre from Ingrediente";
        Query query1 = JPA.em().createQuery(h1);
        List<String> listatodos = query1.getResultList();
        renderJSON(listatodos);
    }


    public void idb(){
        Ingrediente dos2 = new Ingrediente("Lentejas pardina", "Legumbre").save();
        dos2= new Ingrediente("Patatas", "Hortaliza").save();
        dos2= new Ingrediente("Tomates", "Hortaliza").save();
        dos2 = new Ingrediente("Filete de ternera" ,"Carne").save();
        dos2 = new Ingrediente("Pimiento verde", "Hortaliza").save();
        addIngrediente("Pimiento verde");



        Receta rec1 = new Receta("Lentejas a la aragonesa", "Cocer las lentejas").save();
        Receta rec2 = new Receta("Piperrada", "Cortar los pimientos").save();

        IngRec relacio1 = new IngRec(dos2,200,rec1).save();
        Receta r1 = Receta.find("byNombre", "Piperrada").first();
        renderJSON(r1);

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
        Ingrediente ni = Ingrediente.find("byNombre", nombre).first();
        if (ni == null) {
            ni = new Ingrediente(nombre, "j");
            ni.save();
        }

    }
    /*NO hace mas que darme problemas al intentar hacer esta funcion
    puede ser que se por que no ha inicializado la bd??*/

    public void addReceta(){

    }

}