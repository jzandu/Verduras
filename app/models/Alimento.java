package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Alimento extends Model {

    private String nombre;
    private String tipo;
    private boolean vegetariano;


    @OneToMany(mappedBy = "ingredienteReceta")
    List<Ingrediente> ingredienteporreceta;


    public Alimento() {
        nombre = null;
    }//NO termino de entender esto, se podría quitar (en este caso)

    public Alimento(String nombre, String tipo) {
        this.nombre =nombre;
        this.tipo=tipo;
        if(tipo=="Hortaliza"){
            vegetariano=true;
        }else if(tipo=="Cereal"){
            vegetariano =true;
        }else vegetariano=false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}