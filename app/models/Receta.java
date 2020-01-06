package models;
import jdk.internal.org.jline.utils.Log;
import play.db.jpa.Model;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.*;


@Entity
public class Receta extends Model {

    final static Logger log = Logger.getLogger(Receta.class.getName());

    private String nombre;
    @Lob
    private String texto;
    @OneToMany(mappedBy = "recetario")
    private List<Ingrediente> ingredienteporreceta;


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

    public String toString() {
        return this.nombre;
    }
}