package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by ding on 22/03/15.
 */
@Entity
@Table(name = "COMMANDE")
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private Date date;

    private Integer quantite;

    private Recette recette;

    private Recette personnalise;

    private Boutique boutique;

    private InfoPayment infoPayment;

    public Commande(){

    }

    public Commande(Recette recette,Date date, Integer quantite){
        this.recette=recette;
        this.date = date;
        this.quantite = quantite;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ID_COMMANDE",length = 32)
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String toString(){
        return "COMMANDE[" + this.id + "]# Date" + this.date.toString() + ", quantite: " + this.quantite;
    }

    @Column(name = "DATE")
    @NotNull
    public Date getDate(){
        return date;
    }

    public void setDate(Date d){
        date = d;
    }

    @Column(name = "QUANTITE", length = 10)
    @NotNull
    public Integer getQuantite(){
        return quantite;
    }

    public void setQuantite(Integer q){
        quantite = q;
    }

    @ManyToOne(cascade=CascadeType.ALL,optional=false)
    @JoinColumn(name="ID_RECETTE")
    public Recette getRecette(){
        return recette;
    }

    public void setRecette(Recette r){
        recette = r;
    }

    public Recette getPersonnalise(){
        return personnalise;
    }

    public void setPersonnalise(String n, Set<Ingredient> i, Set<Facon> f, Integer t, double p){
        this.personnalise = new Recette();
        personnalise.setNom_recette(n);
        personnalise.setIngredients(i);
        personnalise.setFacons(f);
        personnalise.setTemps_Utiliser(t);
        personnalise.setPrix_recette(p);
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_INFOPAYMENT")
    public InfoPayment getInfoPayment(){
        return infoPayment;
    }

    public void setInfoPayment(InfoPayment i){
        infoPayment = i;
    }

   @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_BOUTIQUE")
    public Boutique getBoutique(){
        return boutique;
    }

    public void setBoutique(Boutique b){
        boutique = b;
    }






}
