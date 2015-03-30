package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by ding on 22/03/15.
 */

@Entity
@Table(name = "INGREDIENT")
public class Ingredient implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nom_Ingredient;

    private double prix_Ingredient;

    private Set<Recette> recettes;

    public Ingredient(){
    }

    public Ingredient(String n, double t){
        this.nom_Ingredient = n;
        this.prix_Ingredient = t;
    }

    public String toString(){
        return "INGREDIENT[" + this.id + "]#" + this.nom_Ingredient + ", t: " + this.prix_Ingredient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_INGREDIENT",length = 32)
    public Long getId() {
        return id;
    }

    @Column(name = "NOM_INGREDIENT", length = 32)
    @NotNull
    public String getNom_Ingredient() {
        return nom_Ingredient;
    }

    public void setNom_Ingredient(String n){
        nom_Ingredient = n;
    }

    @Column(name = "PRIX_INGREDIENT", length = 10)
    @NotNull
    public double getPrix_Ingredient() {
        return prix_Ingredient;
    }

    public void setPrix_Ingredient(double p){
        prix_Ingredient = p;
    }

    @ManyToMany(mappedBy = "ingredients")
    public Set<Recette> getRecettes(){
        return recettes;
    }

    public void setRecettes(Set<Recette> r){
        recettes = r;
    }


}
