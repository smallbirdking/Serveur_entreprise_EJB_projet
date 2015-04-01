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
import java.util.Set;

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
        Recette c = new Recette(n, p);
        entityManager.persist(c);
        return c;
    }

    @Override
    public Recette addIngredientToRecette(String ingredient, String recette) {
        Ingredient i= im.findByName(ingredient);
        Recette r = (Recette) rm.findByName(recette);
        Set<Ingredient> ingredients = r.getIngredients();
        ingredients.add(i);
        r.setIngredients(ingredients);
        entityManager.merge(r);
        //entityManager.merge(i);
        return r;
    }

    @Override
    public Recette deleteIngredientToRecette(String ingredient, String recette) {
        Ingredient i= im.findByName(ingredient);
        Recette r =(Recette) rm.findByName(recette);
        Set<Ingredient> ingredients = r.getIngredients();
        ingredients.remove(ingredient);
        r.setIngredients(ingredients);
        entityManager.merge(r);
        return r;
    }


}