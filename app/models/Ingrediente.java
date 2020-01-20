package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Ingrediente extends Model {

    @ManyToOne
    public Alimento ingredienteReceta;
    private String cantidad;

    @ManyToOne
    public Receta recetario;

    public Ingrediente(){

    }

    public Ingrediente(Alimento ingredienteReceta, String cantidad, Receta recetario){
        this.ingredienteReceta=ingredienteReceta;
        this.cantidad=cantidad;
        this.recetario=recetario;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCantidad() {
        return cantidad;
    }

}
