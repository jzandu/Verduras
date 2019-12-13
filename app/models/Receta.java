package models;
import play.db.jpa.Model;

import java.util.List;

import javax.persistence.*;



@Entity
public class Receta extends Model {
    public String nombreReceta;

    @Lob
    public String textoReceta;

    @OneToMany(mappedBy = "recetario")
    public List<IngRec> ingredienteporreceta;


    public Receta() {
        Receta r  = null;
    }

    public Receta(String nom, String text){
        this.setNombreReceta(nom);
        this.setTextoReceta(text);

    }

    public Receta(String nombreReceta){
        this.setNombreReceta(nombreReceta);
    }

    public void actualizarReceta(String nombreReceta, String textoReceta){
        Receta rc = Receta.find("byNombreReceta",nombreReceta).first();
        rc.delete();
        rc = new Receta(rc.nombreReceta, textoReceta).save();
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String n) {
        this.nombreReceta = n;
    }
    public String getTextoReceta(){
        return textoReceta;
    }
    public  void setTextoReceta(String rec) {
        this.textoReceta =rec;
    }


}