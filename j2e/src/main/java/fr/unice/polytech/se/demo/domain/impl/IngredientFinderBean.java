package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.IngredientFinder;
import fr.unice.polytech.se.demo.entities.Ingredient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by user on 31/03/15.
 */
@Stateless
public class IngredientFinderBean implements IngredientFinder {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Ingredient findByName(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingredient> criteria = builder.createQuery(Ingredient.class);
        Root<Ingredient> from = criteria.from(Ingredient.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("name_Ingredient"), name));
        TypedQuery<Ingredient> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Ingredient findByPrix(double n) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingredient> criteria = builder.createQuery(Ingredient.class);
        Root<Ingredient> from = criteria.from(Ingredient.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("prix_Ingredient"), n));
        TypedQuery<Ingredient> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Ingredient findById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingredient> criteria = builder.createQuery(Ingredient.class);
        Root<Ingredient> from = criteria.from(Ingredient.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("id_Ingredient"), id));
        TypedQuery<Ingredient> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Ingredient> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingredient> cq = cb.createQuery(Ingredient.class);
        TypedQuery<Ingredient> allQuery = entityManager.createQuery(cq.select(cq
                .from(Ingredient.class)));

        return allQuery.getResultList();
    }
}
