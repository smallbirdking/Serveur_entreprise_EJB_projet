package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Commande;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 31/03/15.
 */

public interface CommandeFinder {

    public Commande findById(long n);

    public List<Commande> findByDate(Date d);

    public List<Commande> findByQuantite(int q);

    public List<Commande> findByIdBoutique(long b);

    public List<Commande> findAll();

    //public List<Commande> findLast(int n, int startIndex);
}
