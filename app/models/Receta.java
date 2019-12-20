package models;
import play.db.jpa.Model;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.*;


@Entity
public class Receta extends Model {

    final static Logger log = Logger.getLogger(Receta.class.getName());

    private String nombre;
    @OneToMany(mappedBy = "recetario")
    private List<Ingrediente> ingredienteporreceta;
    @Lob
    private String texto;


    public Receta() {
        Receta r  = null;
    }

    public Receta(String nom, String text){
        this.setNombre(nom);
        this.setTexto(text);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }
    public String getTexto(){
        return texto;
    }
    public  void setTexto(String rec) {
        this.texto=rec;
    }

    public void addIngredienteAReceta(String ingredienteR, int cantidad){
        Alimento ing1 = Alimento.find("byNombre", ingredienteR).first();
        Receta rec1 = Receta.find("byNombre",this.getNombre()).first();

        Ingrediente aux1 = new Ingrediente(ing1, cantidad, rec1).save();
        log.info("Añadido nueva relacion "+aux1.toString());
    }


    public String toString() {
        return this.nombre;
    }
}