package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Recette;

import java.util.List;

/**
 * Created by user on 31/03/15.
 */
public interface CommandeCart {

    public void addRecette(Recette r);

    public List<Recette> getContents();
}
