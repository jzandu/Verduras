package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class IngRec extends Model {

    private String nombre;
    private String recetaI;
    private int cantidad;

    @ManyToOne
    private Ingrediente listadoing;
    @ManyToOne
    private Receta recetario;

    public IngRec(){
        IngRec ir = null;
    }

    public IngRec(String n, int c, String r){
        this.setNombre(n);
        this.setCantidad(c);
        this.setRecetaI(r);
    }

    public void setNombre(String nom){
        this.nombre=nom;
    }

    public void setRecetaI(String rec) {
        this.recetaI = rec;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRecetaI() {
        return recetaI;
    }

    public int getCantidad() {
        return cantidad;
    }
}
