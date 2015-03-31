package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Recette;

/**
 * Created by user on 31/03/15.
 */
public interface RecetteManager {
    public Recette create();

    public Recette create(String n,double p);

    Recette addIngredientToRecette(String ingredient, String recette);

    Recette deleteIngredientToRecette(String ingredient, String recette);
}
