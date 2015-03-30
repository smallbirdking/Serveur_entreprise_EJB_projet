package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by ding on 22/03/15.
 */

@Entity
@Table(name = "FACON")
public class Facon implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nom_Facon;

    private double temps_Utilise;

    private Set<Recette> recettes;

    public Facon(){
    }

    public Facon(String n, double t){
        this.nom_Facon = n;
        this.temps_Utilise = t;
    }

    public String toString(){
        return "FACON[" + this.id + "]#" + this.nom_Facon + ", t: " + this.temps_Utilise;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_FACON",length = 32)
    public Long getId() {
        return id;
    }

    @Column(name = "NOM_FACON", length = 32)
    @NotNull
    public String getNom_Facon() {
        return nom_Facon;
    }

    public void setNom_Facon(String n){
        nom_Facon = n;
    }

    @Column(name = "TEMPS_UTILISE", length = 10)
    @NotNull
    public double getTemps_Utilise() {
        return temps_Utilise;
    }

    public void setTemps_Utilise(double t){
        temps_Utilise = t;
    }

    @ManyToMany(mappedBy = "facons")
    public Set<Recette> getRecettes(){
        return recettes;
    }

    public void setRecettes(Set<Recette> r){
        recettes = r;
    }


}
