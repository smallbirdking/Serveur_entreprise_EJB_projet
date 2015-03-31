package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.IngredientFinder;
import fr.unice.polytech.se.demo.domain.RecetteFinder;
import fr.unice.polytech.se.demo.domain.RecetteManager;
import fr.unice.polytech.se.demo.entities.Ingredient;
import fr.unice.polytech.se.demo.entities.Recette;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by user on 31/03/15.
 */
@Stateless
public class RecetteManagerBean implements RecetteManager {
    @PersistenceContext
    EntityManager entityManager;

    @EJB
    IngredientFinder im = new IngredientFinderBean();

    @EJB
    RecetteFinder rm = new RecetteFinderBean();

    @Override
    public Recette create() {
        return null;
    }

    @Override
    public Recette create(String n, double p) {
        return null;
    }

    @Override
    public Recette addIngredientToRecette(String ingredient, String recette) {
        Ingredient i= im.findByName(ingredient);
        Recette r = rm.findByName(recette);
        r.addIngredient(i);
        entityManager.merge(r);
        //entityManager.merge(i);
        return r;
    }

    @Override
    public Recette deleteIngredientToRecette(String ingredient, String recette) {
        Ingredient i= im.getIngredientByName(ingredient);
        Recette r = findByName(recette);
        r.removeIngredient(i);
        return r;
    }


}