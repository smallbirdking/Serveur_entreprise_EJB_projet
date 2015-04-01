package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Commande;

import java.util.List;

/**
 * Created by user on 31/03/15.
 */
public interface CommandeCart {

    public void addCommande(Commande c);

    public List<Commande> getContents();
}
