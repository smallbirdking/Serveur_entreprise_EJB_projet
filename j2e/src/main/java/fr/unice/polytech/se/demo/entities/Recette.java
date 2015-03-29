package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/** * Created on 21/03/15. */
@Entity
@Table(name = "RECETTES")
public class Recette implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name_Recette;
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();
    private Set<Facon> facon = new HashSet<Facon>();
    private double temps_Utiliser;
    private double prix_Recette;
    private Commande commande; //Pour une recette spéciale

    Recette(String special,double taxe) {
        name = special;
        this.taxe = taxe;
    } //Pour une rectte standard

    Recette(double taxe) {
        this.taxe = taxe;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    @NotNull
    public String getName() {
        return name;
    }

    @Column(name = "TOTALHT")
    @NotNull
    public double getTotalHT() {
        return totalHT;
    }

    @OneToMany(mappedBy = "recette")
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Commande getCommande(){
        return commande;
    }

    public void addIngredient(Ingredient i) {
        ingredients.add(i);
    }

    public void removeIngredient(Ingredient i2) {
        ingredients.remove(i2);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        String toSend = "Recette[" + this.id + "]"+"\n"; toSend += ingredients.toString();
        return toSend;
    }

    public boolean equals(Object o) {
        if (o instanceof Recette) {
            Recette that = (Recette) o;
            return (that.ingredients.equals(this.ingredients));
        }
        return false;
    }
}
