package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/** * Created on 21/03/15. */
@Entity
@Table(name = "RECETTES")
public class Recette implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nom_recette;
    private Set<Ingredient> ingredients;
    private Set<Facon> facons;
    private Set<Preference> preferences;
    private double temps_Utiliser;
    private double prix_recette;
    private Set<Commande> commandes;
    private Set<Boutique> boutiques;

    public Recette(){

    }

    public Recette(String n,double p) {
        this.nom_recette = n;
        this.prix_recette = p;
    }

    public String toString() {
        String msg = "RECETTE[" + this.id + "]#";
        msg += "nom: " + this.nom_recette + ", ";
        msg += "temp_utilise: " + this.temps_Utiliser + ", ";
        msg += "prix_recette: " + this.prix_recette;
        return msg;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_RECETTE",length = 32)
    public Long getId() {
        return id;
    }

    @Column(name = "NOM_RECETTE", length = 32)
    @NotNull
    public String getNom_recette(){
        return nom_recette;
    }

    public void setNom_recette(String nr){
        nom_recette = nr;
    }

    @Column(name = "TEMPS_UTILISER",length = 32)
    @NotNull
    public double getTemps_Utiliser(){
        return temps_Utiliser;
    }

    public void setTemps_Utiliser(double tu){
        temps_Utiliser = tu;
    }

    @Column(name = "PRIX_RECETTE", length = 32)
    @NotNull
    public double getPrix_recette(){
        return prix_recette;
    }

    public void setPrix_recette(double pr){
        prix_recette = pr;
    }

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @AssociationTable(table = @Table(name = "PREFERENCE_RECETTE"),
            joinColumns = {@JoinColumn(name = "ID_RECETTE",referencedColumnName="ID_RECETTE")},
            inverseJoinColumns = {@JoinColumn(name = "ID_PREFERENCE",referencedColumnName="ID_PREFERENCE")})
    public Set<Preference> getPreferences(){
        return preferences;
    }

    public void setPreferences(Set<Preference> p){
        preferences = p;
    }

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @AssociationTable(table = @Table(name = "FACON_RECETTE"),
            joinColumns = {@JoinColumn(name = "ID_RECETTE",referencedColumnName="ID_RECETTE")},
            inverseJoinColumns = {@JoinColumn(name = "ID_FACON",referencedColumnName="ID_FACON")})
    public Set<Facon> getFacons(){
        return facons;
    }

    public void setFacons(Set<Facon> f){
        facons = f;
    }

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @AssociationTable(table = @Table(name = "INGREDIENT_RECETTE"),
            joinColumns = {@JoinColumn(name = "ID_RECETTE",referencedColumnName="ID_RECETTE")},
            inverseJoinColumns = {@JoinColumn(name = "ID_INGREDIENT",referencedColumnName="ID_INGREDIENT")})
    public Set<Ingredient> getIngredients(){
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> i){
        ingredients = i;
    }

    @OneToMany(mappedBy="recette",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    public Set<Commande> getCommandes(){
        return commandes;
    }

    public void setCommandes(Set<Commande> c){
        commandes = c;
    }

    public void addCommande(Commande c){
        commandes.add(c);
    }

    public void removeCommande(Commande c){
        commandes.remove(c);
    }

    @OneToMany(mappedBy="recette_du_jour",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    public Set<Boutique> getBoutiques(){
        return boutiques;
    }

    public void setBoutiques(Set<Boutique> b){
        boutiques = b;
    }

    public void addBoutique(Boutique b){
        boutiques.add(b);
    }

    public void removeBoutique(Boutique b){
        boutiques.remove(b);
    }


}
