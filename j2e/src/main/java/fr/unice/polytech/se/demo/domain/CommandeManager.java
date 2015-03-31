package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Commande;

/**
 * Created by user on 31/03/15.
 */
public interface CommandeManager {
    public Commande create(String name);
}
