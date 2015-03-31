package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Ingredient;

/**
 * Created by user on 31/03/15.
 */
public interface IngredientManager {
    public Ingredient create(String name, double t);

    public Ingredient deleteIngredient(String name );
}
