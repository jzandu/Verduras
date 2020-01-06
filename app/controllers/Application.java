package controllers;

import play.*;
import play.mvc.*;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;

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

    public void addIngrediente(String receta, String alimento, String cantidad){
        Receta r1 = Receta.find("byNombre",receta).first();
        Alimento ing1 = Alimento.find("byNombre", alimento).first();

        Ingrediente aux1 = new Ingrediente(ing1, cantidad, r1).save();
        log.info("Añadido nueva relacion "+aux1.toString());
    }


    public void idb() throws IOException, URISyntaxException {
        Alimento aux0;//hay que dejarlo fuera del bucle para que no de error

        //Añadidos nuevos alimentos a la BBDD para que sea mas rápido
        File file = new File("Verduras/documentation/files/AlimentosFile");
        FileReader f = new FileReader(file);
        BufferedReader br = new BufferedReader(f);

        String linea = br.readLine();
        while (!linea.equals(".")){
            String campo[] = linea.split(",");
            aux0 = new Alimento(campo[0], campo[1], campo[2]);
            log.info(aux0.toString());
            aux0.save();
            linea = br.readLine();
        }

        //Nuevas recetas en la BBDD CON SISTEMA SCANNER
        Scanner scan = new Scanner(new File("Verduras/documentation/files/RecetasFile"));
        scan.useDelimiter(Pattern.compile("-----\n"));
        Receta aux1;

        while (scan.hasNext()){
            String line = scan.next();
            String campo[] = line.split("#");
            log.info(campo[0]);
            aux1 = new Receta(campo[0],campo[1]);
            aux1.save();
            campo = null;
        }

        //Diferentes metodos de añadir alimentos y recetas
        Alimento dos2 = new Alimento("Lentejas pardina", "Legumbre").save();
        dos2= new Alimento("Patatas", "Hortaliza").save();
        dos2= new Alimento("Tomates", "Hortaliza").save();
        dos2 = new Alimento("Filete de ternera" ,"Carne").save();
        dos2 = new Alimento("Pimiento verde", "Hortaliza").save();

        Receta rec1 = new Receta("Lentejas a la aragonesa", "Cocer las lentejas").save();
        rec1 = new Receta("Piperrada", "Cortar los pimientos").save();
        rec1= new Receta("Arroz a la cubana", "Freir el huevo y cocer el arroz").save();

        addAlimento("Pimiento verde", "Hortaliza");
        addAlimento("Pimiento rojo", "Hortaliza");
        addAlimento("Arroz blanco", "Cereal");
        addAlimento("Huevos de gallina", "Huevos");
        addAlimento("Lomo de salmón", "Pescado");

        addIngrediente("Arroz a la cubana", "Huevos de gallina", "2");
        addIngrediente("Arroz a la cubana", "Arroz blanco", "100g");
        addIngrediente("Lentejas a la aragonesa", "Lentejas pardina", "200g");

        addIngrediente("Risotto con Jamon\n", "Arroz bomba", "100g");
        addIngrediente("Risotto con Jamon\n", "Jamon iberico", "2 trozos");
        addIngrediente("Risotto con Jamon\n","Ajos", "1");
        addIngrediente("Risotto con Jamon\n","Aceite de oliva", "50ml");

    }

}