package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Preference;

import java.util.List;

/**
 * Created by user on 31/03/15.
 */
public interface PreferenceFinder {
    public Preference findByName(String n);

    public List<Preference> findAll();

}
