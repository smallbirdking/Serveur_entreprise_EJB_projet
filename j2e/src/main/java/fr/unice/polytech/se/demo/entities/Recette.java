package fr.unice.polytech.se.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ding on 22/03/15.
 */
@Entity
@Table(name = "RECETTE")
public class Recette implements Serializable {


    private String id_Recette;

    @Id
    public String getId_Recette() {
        return id_Recette;
    }

    public void setId_Recette(String id_Recette) {
        this.id_Recette = id_Recette;
    }
}
