package models;
import play.db.jpa.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;


@Entity
public class Receta extends Model {
    final static Logger log = Logger.getLogger(Receta.class.getName());
    @
    private String nombre;
    @Lob
    private String texto;

    @OneToMany(mappedBy = "recetario")
    private List<IngRec> ingredienteporreceta;


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

    public void addIReceta(String ingredienteR, int cantidad){
        Ingrediente ing1 = Ingrediente.find("byNombre", ingredienteR).first();
        Receta rec1 = Receta.find("byNombre",this.getNombre()).first();
        IngRec aux1 = new IngRec(ing1, cantidad, rec1).save();
        log.info("Añadido nueva relacion "+aux1.toString());
    }
}