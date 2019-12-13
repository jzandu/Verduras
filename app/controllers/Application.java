package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import java.util.logging.Logger;

import models.*;
import javax.persistence.*;
import play.db.jpa.*;


public class Application extends Controller{
    final static Logger log = Logger.getLogger(Application.class.getName());

    public void index() {
        render();
    }


    public void idb(){
        Ingrediente dos2 = new Ingrediente("Lentejas pardina", "Legumbre").save();
        Receta rec1 = new Receta("Lentejas a la aragonesa", "Cocer las lentejas").save();
        Receta rec2 = new Receta("Piperrada", "Cortar los pimientos").save();

        dos2= new Ingrediente("Patatas", "Hortaliza").save();
        dos2= new Ingrediente("Tomates", "Hortaliza").save();
        dos2 = new Ingrediente("Filete de ternera" ,"Carne").save();
        dos2 = new Ingrediente("Pimiento verde", "Hortaliza").save();

        addIngrediente("Pimiento verde", "Hortaliza");
        addIngrediente("Pimiento rojo", "Hortaliza");
        addIngrediente("Arroz blanco", "Cereal");
        addIngrediente("Huevos de gallina", "Huevos");
        addIngrediente("Lomo de salmón", "Pescado");

        Receta rec3= new Receta("Arroz a la cubana", "Freir el huevo y cocer el arroz").save();
        rec3.addIReceta("Huevos de gallina", 2);
        rec3.addIReceta("Arroz blanco", 2);
        verIngredientes("Arroz a la cubana");

    }


    public void hacerMenu() {

    }

    public String masRecetas() {
        return null;
    }
    /*Aqui tengo un problema, ya que mi clase intermedia que relaciona ingredientes, recetas y cantidades tiene id, con lo cual debería hacer un query que diga:
     dame los nombres de ingrediente de...tengo que conseguir el id antes y eso está en la base de datos no en java*/
    public void verIngredientes(String nombreReceta) {
        Receta receta = Receta.find("byNombre", nombreReceta).first();
        receta = Receta.find("byId", receta).fetch();
        Query query1 = JPA.em().createQuery("select listadoing_id from IngRec where recetario_id = "+receta.ge);
        List<String> listatodos = query1.getResultList();
        renderJSON(listatodos);
        //OPCIONES POR ORDEN DE DIFICULTAD
        // 1 Ves una receta y te muestra sus ingredientes
        // 2 Busca las recetas que contienen un ingrediente

    }


    public void addIngrediente(String nombre,String tipo){
        Ingrediente ni = Ingrediente.find("byNombre", nombre).first();
        if (ni == null) {
            ni = new Ingrediente(nombre,tipo);
            ni.save();
        }

    }
}