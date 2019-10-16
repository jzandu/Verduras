package models;
import play.db.jpa.Model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "LIBRO RECETAS")
public class Receta extends Model {
    private String nombre;
    @Lob
    private String texto;

    @ManyToMany
    List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

    public Receta() {
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

}