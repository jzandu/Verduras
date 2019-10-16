package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingrediente extends Model {
    private String nom;

    @ManyToMany(mappedBy = "recetas")
    List<Receta> recetas = new ArrayList<Receta>();

    public Ingrediente(String n) {
        this.nom = n;
    }

    public Ingrediente() {
        nom = null;
    }//NO termino de entender esto, se podría quitar (en este caso)

    public String getNom() {
        return nom;
    }

    public void setNom(String n) {
        this.nom = n;
    }

}
