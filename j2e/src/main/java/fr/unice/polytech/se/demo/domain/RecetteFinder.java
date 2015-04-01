package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Recette;

import java.util.List;

/**
 * Created by user on 31/03/15.
 */
public interface RecetteFinder {
    public Recette findById(int n);

    public Recette findByName(String n);

    public List<Recette> findByPrix(double p);

    public List<Recette> findByTempsUtilise(int t);

    public List<Recette> findAll();

    public List<Recette> findLast(int n, int startIndex);
}
