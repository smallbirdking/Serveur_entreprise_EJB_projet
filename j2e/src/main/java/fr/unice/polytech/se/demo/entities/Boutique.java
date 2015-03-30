package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by ding on 22/03/15.
 */

@Entity
@Table(name = "BOUTIQUE")
public class Boutique implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Recette recette_du_jour;

    private String addresseBoutique;

    private double tax;

    private Integer chiffreVente;

    private Set<Preference> preferences;

    public Boutique(){

    }

    public Boutique(Recette recette_du_jour, String addresseBoutique, double tax, Integer chiffreVente){
        this.recette_du_jour = recette_du_jour;
        this.addresseBoutique = addresseBoutique;
        this.tax = tax;
        this.chiffreVente = chiffreVente;
    }

    public String toString(){
        return "BOUTIQUE[" + this.id + "]# Recettedujour: " + this.recette_du_jour.toString() + "\naddresseBoutique: " + this.addresseBoutique +
                "\n tax: " + this.tax + "\nchiffreVente: "+ this.chiffreVente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_BOUTIQUE",length = 32)
    public Long getId() {
        return id;
    }

    @ManyToOne(cascade=CascadeType.ALL,optional=false)
    @JoinColumn(name="ID_RECETTE")
    public Recette getRecette_du_jour(){
        return recette_du_jour;
    }

    public void setRecette_du_jour(Recette r){
        recette_du_jour = r;
    }

    @Column(name = "ADDRESSEBOUTIQUE", length = 32)
    @NotNull
    public String getAddresseBoutique(){
        return addresseBoutique;
    }

    public void setAddresseBoutique(String ab){
        addresseBoutique = ab;
    }

    @Column(name = "TAX", length = 10)
    @NotNull
    public double getTax(){
        return tax;
    }

    public void setTax(double t){
        tax = t;
    }

    @Column(name = "CHIFFREVENTE", length = 10)
    public Integer getChiffreVente(){
        return chiffreVente;
    }

    public void setChiffreVente(Integer cv){
        chiffreVente = cv;
    }

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @AssociationTable(table = @Table(name = "BOUTIQUE_PREFERENCE"),
            joinColumns = {@JoinColumn(name = "ID_BOUTIQUE",referencedColumnName="ID_BOUTIQUE")},
            inverseJoinColumns = {@JoinColumn(name = "ID_PREFERENCE",referencedColumnName="ID_PREFERENCE")})
    public Set<Preference> getPreferences(){
        return preferences;
    }

    public void setPreferences(Set<Preference> p){
        preferences = p;
    }






}
