package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by ding on 22/03/15.
 */

@Entity
@Table(name = "INFOPAYMENT")
public class InfoPayment implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nom_Client;

    private String addresse_Client;

    private String compte_Banque;

    public InfoPayment(){}

    public InfoPayment(String nc, String ac, String cb){
        this.nom_Client = nc;
        this.addresse_Client = ac;
        this.compte_Banque = cb;
    }

    public String toString(){
        return "INFOPAYMENT[" + this.id + "]# nom_client: " + this.nom_Client + ", addresse_client: " + this.addresse_Client + ", compte_banque: " + this.compte_Banque;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_INFOPAYMENT",length = 32)
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Column(name = "NOM_CLIENT", length = 32)
    @NotNull
    public String getNom_Client(){
        return nom_Client;
    }

    public void setNom_Client(String nc){
        nom_Client = nc;
    }

    @Column(name = "ADDRESSE_CLIENT", length = 32)
    @NotNull
    public String getAddresse_Client(){
        return addresse_Client;
    }

    public void setAddresse_Client(String ac){
        addresse_Client = ac;
    }

    @Column(name = "COMPTE_BANQUE", length = 32)
    @NotNull
    public String getCompte_Banque(){
        return compte_Banque;
    }

    public void setCompte_Banque(String cb){
        compte_Banque = cb;
    }


}
