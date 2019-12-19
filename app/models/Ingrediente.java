package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Ingrediente extends Model {

    @ManyToOne
    public Alimento ingredienteReceta;
    private int cantidad;

    @ManyToOne
    public Receta recetario;

    public Ingrediente(Alimento ingredienteReceta, int cantidad, Receta recetario){
        this.ingredienteReceta=ingredienteReceta;
        this.cantidad=cantidad;
        this.recetario=recetario;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String toString(){
        return (ingredienteReceta.getNombre());
    }


}
