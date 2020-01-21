package models;

import play.data.validation.*;

import play.db.jpa.Model;

import javax.persistence.Entity;

import javax.persistence.ManyToMany;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Client extends Model {
    @Required
    public String nickname;

    @Required
    public String password;

    public String name;

    @ManyToMany 
    public List<Receta> favoritos = new ArrayList<Receta>();

    public Client (String name, String nickname, String password){
        this.name =name;
        this.nickname = nickname;
        this.password =password;
    }
    public Client(){
        super();

    }

    public static Client connect(String n, String p){
        Client c = Client.find("byNombreAndPassword",n,p).first();
        return c;
    }

    public String toString() {
        return nickname;
    }
}
