package fr.unice.polytech.se.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ding on 22/03/15.
 */
@Entity
@Table(name = "COMMANDE")
public class Commande implements Serializable {
    private String id_Commande;

    @Id
    public String getId_Commande() {
        return id_Commande;
    }

    public void setId_Commande(String id_Commande) {
        this.id_Commande = id_Commande;
    }
}
