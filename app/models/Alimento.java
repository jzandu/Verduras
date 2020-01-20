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
        if(tipo=="Carne"){
            vegetariano=false;
        }else if(tipo=="Pescado"){
            vegetariano =false;
        }else vegetariano=true;
    }

    public Alimento(String s, String s1, String s2) {
        this.nombre=s;
        this.tipo=s1;
        this.vegetariano=Boolean.parseBoolean(s2);
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

    public String toString(){
        return "Alimento "+this.nombre+
                " de tipo: "+tipo;
    }


}