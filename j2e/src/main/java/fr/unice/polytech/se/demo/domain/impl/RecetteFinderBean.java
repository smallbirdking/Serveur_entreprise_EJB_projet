package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.RecetteFinder;
import fr.unice.polytech.se.demo.entities.Recette;

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
public class RecetteFinderBean implements RecetteFinder {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Recette findById(int id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Recette> criteria = builder.createQuery(Recette.class);
        Root<Recette> from = criteria.from(Recette.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("id_Recette"), id));
        TypedQuery<Recette> query = entityManager.createQuery(criteria.select(criteria
                .from(Recette.class)));
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Recette> findByName(String n) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Recette> criteria = builder.createQuery(Recette.class);
        Root<Recette> from = criteria.from(Recette.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("name_Recette"), n));
        TypedQuery<Recette> query = entityManager.createQuery(criteria.select(criteria
                .from(Recette.class)));
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Recette> findByPrix(double p) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Recette> criteria = builder.createQuery(Recette.class);
        Root<Recette> from = criteria.from(Recette.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("prix_Recette"), p));
        TypedQuery<Recette> query = entityManager.createQuery(criteria.select(criteria
                .from(Recette.class)));
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Recette> findByTempsUtilise(int t) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Recette> criteria = builder.createQuery(Recette.class);
        Root<Recette> from = criteria.from(Recette.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("TempsUtilise"), t));
        TypedQuery<Recette> query = entityManager.createQuery(criteria.select(criteria
                .from(Recette.class)));
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Recette> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Recette> cq = cb.createQuery(Recette.class);
        TypedQuery<Recette> allQuery = entityManager.createQuery(cq.select(cq
                .from(Recette.class)));

        return allQuery.getResultList();
    }

    @Override
    public List<Recette> findLast(int n, int startIndex) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Recette> criteria = builder.createQuery(Recette.class);

        Root<Recette> from = criteria.from(Recette.class);
        criteria.select(from);
        criteria.orderBy(builder.desc(from.get("id")));

        TypedQuery<Recette> query = entityManager.createQuery(criteria);
        query.setFirstResult(startIndex);
        query.setMaxResults(n);

        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
