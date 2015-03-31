package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Commande;

import java.util.List;

/**
 * Created by user on 31/03/15.
 */
public interface CommandeFinder {

    public Commande findByName(String n);

    public List<Commande> findAll();

    public List<Commande> findLast(int n, int startIndex);
}
