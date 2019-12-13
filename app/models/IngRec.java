package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class IngRec extends Model {

    private int cantidad;
    @ManyToOne
    private Ingrediente listadoing;
    @ManyToOne
    private Receta recetario;

    public IngRec(){
        IngRec ir = null;
    }

    public IngRec(Ingrediente listadoing, int c){
        this.listadoing=listadoing;
        this.setCantidad(c);
        this.recetario=recetario;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad()


}
