package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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

    private Boutique boutique;

    private InfoPayment infoPayment;

    public Commande(){

    }

    public Commande(Date date, Integer quantite){
        this.date = date;
        this.quantite = quantite;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_COMMANDE",length = 32)
    public Long getId() {
        return id;
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
