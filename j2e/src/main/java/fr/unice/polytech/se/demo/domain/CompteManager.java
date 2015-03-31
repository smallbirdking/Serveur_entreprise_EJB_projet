package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Compte;

/**
 * Created by user on 31/03/15.
 */
public interface CompteManager {
    public Compte create(String name);
}
