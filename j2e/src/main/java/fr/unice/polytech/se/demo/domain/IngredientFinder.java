package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Ingredient;

import java.util.List;

/**
 * Created by user on 31/03/15.
 */
public interface IngredientFinder {
    public Ingredient findByName(String n);

    public Ingredient findByPrix(int n);

    public Ingredient findById(int n);

    public List<Ingredient> findAll();

}
