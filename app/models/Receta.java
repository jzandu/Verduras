package models;
import play.db.jpa.Model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
public class Receta extends Model {

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

}