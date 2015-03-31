package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Compte;

import java.util.List;

/**
 * Created by user on 31/03/15.
 */
public interface CompteFinder {
    public Compte findByName(String n);

    public List<Compte> findAll();

    public List<Compte> findLast(int n, int startIndex);
}
