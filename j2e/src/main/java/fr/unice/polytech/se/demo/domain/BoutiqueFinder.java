package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Boutique;

import java.util.List;

/**
 * Created by user on 31/03/15.
 */
public interface BoutiqueFinder {

    //public Boutique findByName(String n);

    public Boutique findById(int n);

    public Boutique findByAddresse(String add);

    public Boutique findByChiffreVente(int n);

    public List<Boutique> findAll();

}
