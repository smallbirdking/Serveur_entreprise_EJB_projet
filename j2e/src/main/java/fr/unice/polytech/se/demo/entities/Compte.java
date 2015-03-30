package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by ding on 22/03/15.
 */
@Entity
@Table(name = "COMPTE")
public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private double credit_Carte_Cadeau;

    private Integer id_Client;

    private String code;

    public Compte(){}

    public Compte(double ccc, Integer client, String code){
        this.credit_Carte_Cadeau = ccc;
        this.id_Client = client;
        this.code = code;
    }

    public String toString(){
        return "COMPTE[" + this.id + "]# " + "client: " + this.id_Client + ", credit: " + this.credit_Carte_Cadeau + ", code: " + this.code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_COMPTE",length = 32)
    public Long getId() {
        return id;
    }

    @Column (name = "CREDIT_CARTE_CADEAU", length = 32)
    @NotNull
    public double getCredit_Carte_Cadeau(){
        return credit_Carte_Cadeau;
    }

    public void setCredit_Carte_Cadeau(double ccc){
        credit_Carte_Cadeau = ccc;
    }

    @Column(name = "ID_CLIENT", length = 10)
    @NotNull
    public Integer getId_Client(){
        return id_Client;
    }

    public void setId_Client(Integer client){
        id_Client = client;
    }

    @Column(name = "CODE", length = 32)
    @NotNull
    public String getCode(){
        return code;
    }

    public void setCode(String c){
        code = c;
    }





}
