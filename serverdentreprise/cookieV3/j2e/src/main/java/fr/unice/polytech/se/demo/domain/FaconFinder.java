package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Facon;

import java.util.List;

/**
 * Created by user on 31/03/15.
 */
public interface FaconFinder {
    public Facon findById(long id);

    public Facon findByName(String n);

    public Facon findByTemps(double time);

    public List<Facon> findAll();

    //public List<Facon> findLast(int n, int startIndex);
}
