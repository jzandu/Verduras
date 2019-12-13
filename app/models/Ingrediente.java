package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Ingrediente extends Model {

    @NombreIngrediente
    @Required
    public String nombreIngrediente;

    /*@OneToMany(mappedBy = "listadoing")
    public List<IngRec> ingredientePorReceta;
*/

    public Ingrediente() {
        nombreIngrediente = null;
    }//NO termino de entender esto, se podría quitar (en este caso)

    public Ingrediente(String n) {
        this.setNombreIngrediente(n);
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String n) {
        this.nombreIngrediente = n;
    }

    /*public static void addReceta(String nombre){
        Ingrediente n = new Ingrediente(nombre).save();

    }*/


    }

