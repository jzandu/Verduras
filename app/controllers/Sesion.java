package controllers;

import play.mvc.Controller;

public interface Sesion extends Controller {

    static void inicio(){
        render("WEB inicio");
    }
    void hacerMenu();
    String masRecetas();
    void verIngredientes();

}
