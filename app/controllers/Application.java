package controllers;

import play.mvc.*;
import models.*;

public class Application extends Controller{
    public static void index() {
        inicializarBD();
        renderTemplate("Application/addIngredienteTemplate.html");
    }
    public static void inicializarBD(){

        //addIngredienteTemplate("Pimiento verde", 2, "Piperrada");
        Ingrediente dos2 = new Ingrediente("Lentejas pardina").save();
        dos2 = new Ingrediente("Lenteja pardina").save();
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


    //Metodo relacionado con el formulario HTML
    public static void addIngredienteTemplate(String nuevoIngrediente, int nuevaCantidad, String nuevaReceta){
        Ingrediente ni = Ingrediente.find("byNombreIngrediente", nuevoIngrediente).first();
        if (ni == null) {
            ni = new Ingrediente(nuevoIngrediente).save();
        }
            Receta nc = new Receta(nuevaReceta, null).save();
            IngRec ic = new IngRec(ni, nuevaCantidad, nc).save();
        }

    public static void addRecetaTemplate(String nombreReceta, String textoReceta){
        Receta rc = Receta.find("byNombreReceta",nombreReceta).first();
        if (rc.getTextoReceta() == null) {
            rc.actualizarReceta(nombreReceta, textoReceta);
        } else renderText("Ingrediente añadido");
    }

    /*Metodo para añadir un ingrediente a la clase ingrediente
    public static void addIngrediente(String nuevoIngrediente) {

        } else renderText("Ingrediente ya añadido.");*/
    }



