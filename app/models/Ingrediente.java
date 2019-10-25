package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingrediente extends Model {
    private String nom;

    @OneToMany(mappedBy = "listadoing")
    private List<IngRec> ingredienteporreceta;


    public Ingrediente() {
        nom = null;
    }//NO termino de entender esto, se podría quitar (en este caso)

    public Ingrediente(String n) {
        this.setNom(n);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String n) {
        this.nom = n;
    }

    public static void addIngrediente(String nombre){
        Ingrediente n = new Ingrediente(nombre).save();

    }

}
