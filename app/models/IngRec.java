package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class IngRec extends Model {

    public int cantidad;
    @ManyToOne
    public Ingrediente listadoing;
    @ManyToOne
    public Receta recetario;
    @ManyToOne
    public Client guardadoFav;

    public IngRec(){
        IngRec ir = null;
    }

    public IngRec(Ingrediente listadoing, int cantidadPorReceta, Receta recetario){
        this.listadoing=listadoing;
        this.setCantidad(cantidadPorReceta);
        this.recetario=recetario;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String toString(){
        return "[Receta: "+ this.recetario.getNombreReceta();
    }



    }
