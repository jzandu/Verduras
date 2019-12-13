package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Ingrediente extends Model {
    private String nombre;

    @OneToMany(mappedBy = "listadoing")
    private List<IngRec> ingredienteporreceta;


    public Ingrediente() {
        nombre = null;
    }//NO termino de entender esto, se podría quitar (en este caso)

    public Ingrediente(String n) {
        this.nombre =n;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    /*public static void addIngrediente(String nombre){
        Ingrediente n = new Ingrediente(nombre).save();

    }*/


}