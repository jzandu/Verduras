package controllers;

import play.*;
import play.mvc.*;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

import models.*;
import javax.persistence.*;
import play.db.jpa.*;


public class Application extends Controller {
    final static Logger log = Logger.getLogger(Application.class.getName());

    public static void index() {
        render();
    }

    public void hacerMenu() {

    }

    public String masRecetas() {
        return null;
    }
    /*Aqui tengo un problema, ya que mi clase intermedia que relaciona ingredientes, recetas y cantidades tiene id, con lo cual debería hacer un query que diga:
     dame los nombres de ingrediente de...tengo que conseguir el id antes y eso está en la base de datos no en java
     Error raised is : The return type is incompatible with Model.getId()
    */

    public void verIngredientes(String nombreReceta) {
        Receta receta = Receta.find("byNombre", nombreReceta).first();
        if (receta!=null) {

            Query query1 = JPA.em().createQuery("select ingredienteReceta.nombre, cantidad from Ingrediente where recetario =:nombreReceta");
            query1.setParameter("nombreReceta", receta);
            List<Alimento> listatodos = query1.getResultList();
            renderJSON(listatodos);
        } else{
            String h1 = ("select nombre, texto from Receta");
            Query query2 = JPA.em().createQuery(h1);
            List<Receta> listaReceta = query2.getResultList();
            renderJSON(listaReceta);
        }
    }

    public void json0(){
        String h1 = "select nombre from Ingrediente";
        Query query1 = JPA.em().createQuery(h1);
        List<String> listatodos = query1.getResultList();
        renderJSON(listatodos);
    }

    public void json1(){
        Receta r1 = Receta.find("byNombre", "Piperrada").first();
        renderJSON(r1);
    }
    public void json2(){
        Query query3 = JPA.em().createQuery("select listadoing from IngRec where recetario_id= 12", Alimento.class);
        List<String> lista3 = query3.getResultList();
        renderJSON(lista3);
    }


        //OPCIONES POR ORDEN DE DIFICULTAD
        // 1 Ves una receta y te muestra sus ingredientes
        // 2 Busca las recetas que contienen un ingrediente



    public void addAlimento(String nombre, String tipo){
        Alimento ni = Alimento.find("byNombre", nombre).first();
        if (ni == null) {
            ni = new Alimento(nombre,tipo);
            ni.save();
        }

    }


    public void idb() throws IOException {
        Alimento aux0;
        File file = new File("documentation/files/AlimentosJSON");
        FileReader f = new FileReader(file);
        BufferedReader br = new BufferedReader(f);

        String linea = br.readLine();
        while (!linea.equals(".")){
            String campo[] = linea.split(",");
            log.info(campo[0]+campo[1]+campo[2]);
            aux0 = new Alimento(campo[0], campo[1], campo[2]);
            aux0.save();
            linea = br.readLine();
        }


        Alimento dos2 = new Alimento("Lentejas pardina", "Legumbre").save();
        Receta rec1 = new Receta("Lentejas a la aragonesa", "Cocer las lentejas").save();
        Receta rec2 = new Receta("Piperrada", "Cortar los pimientos").save();

        dos2= new Alimento("Patatas", "Hortaliza").save();
        rec1.addIngredienteAReceta("Lentejas pardina", 200);

        dos2= new Alimento("Tomates", "Hortaliza").save();
        dos2 = new Alimento("Filete de ternera" ,"Carne").save();
        dos2 = new Alimento("Pimiento verde", "Hortaliza").save();

        addAlimento("Pimiento verde", "Hortaliza");
        addAlimento("Pimiento rojo", "Hortaliza");
        addAlimento("Arroz blanco", "Cereal");
        addAlimento("Huevos de gallina", "Huevos");
        addAlimento("Lomo de salmón", "Pescado");

        Receta rec3= new Receta("Arroz a la cubana", "Freir el huevo y cocer el arroz").save();
        rec3.addIngredienteAReceta("Huevos de gallina", 2);
        rec3.addIngredienteAReceta("Arroz blanco", 2);

    }

}