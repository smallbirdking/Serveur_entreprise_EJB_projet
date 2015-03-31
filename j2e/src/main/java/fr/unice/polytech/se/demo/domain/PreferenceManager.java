package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Preference;

/**
 * Created by user on 31/03/15.
 */
public interface PreferenceManager {
    public Preference create(String name);
}
