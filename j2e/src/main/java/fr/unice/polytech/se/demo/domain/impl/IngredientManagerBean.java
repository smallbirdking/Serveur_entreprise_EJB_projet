package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.IngredientFinder;
import fr.unice.polytech.se.demo.domain.IngredientManager;
import fr.unice.polytech.se.demo.entities.Ingredient;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by user on 31/03/15.
 */
@Stateless
public class IngredientManagerBean implements IngredientManager {
    @PersistenceContext
    EntityManager entityManager;

    @EJB
    IngredientFinder finder;

    @Override
    public Ingredient create(String name, double t) {
        Ingredient i = new Ingredient(name, t);
        entityManager.persist(i);
        return i;
    }

    @Override
    public Ingredient deleteIngredient(String n){
        Ingredient i = finder.findByName(n);
        entityManager.remove(i);
        return i;
    }

}