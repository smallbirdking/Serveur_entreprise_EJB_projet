package fr.unice.polytech.se.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ding on 22/03/15.
 */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient implements Serializable {
    private String id_Ingredient;

    @Id
    public String getIdIngredient() {
        return id_Ingredient;
    }

    public void setIdIngredient(String id_Ingredient) {
        this.id_Ingredient = id_Ingredient;
    }
}
