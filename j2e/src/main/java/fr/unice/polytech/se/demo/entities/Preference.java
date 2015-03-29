package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ding on 22/03/15.
 */

@Entity
@Table(name = "PREFERENCE")
public class Preference implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private Compte compte;

    private InfoPayment infoPayment;

    public Preference(){}

    public Preference(Compte c, InfoPayment p){
        this.compte = c;
        this.infoPayment = p;
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_COMPTE")
    public Compte getCompte(){
        return compte;
    }

    public void setCompte(Compte c){
        compte = c;
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_INFOPAYMENT")
    public InfoPayment getInfoPayment(){
        return infoPayment;
    }

    public void setInfoPayment(InfoPayment p){
        infoPayment = p;
    }
}
