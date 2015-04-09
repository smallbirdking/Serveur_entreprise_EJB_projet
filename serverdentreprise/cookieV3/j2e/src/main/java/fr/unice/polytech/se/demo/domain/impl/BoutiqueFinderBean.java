package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.BoutiqueFinder;
import fr.unice.polytech.se.demo.entities.Boutique;

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
public class BoutiqueFinderBean implements BoutiqueFinder {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Boutique findById(int id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Boutique> criteria = builder.createQuery(Boutique.class);
        Root<Boutique> from = criteria.from(Boutique.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("id"), id));
        TypedQuery<Boutique> query = entityManager.createQuery(criteria.select(criteria
                .from(Boutique.class)));
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boutique findByAddresse(String addresseBoutique) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Boutique> criteria = builder.createQuery(Boutique.class);
        Root<Boutique> from = criteria.from(Boutique.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("addresseBoutique"), addresseBoutique));
        TypedQuery<Boutique> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boutique findByChiffreVente(int chiffreVente) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Boutique> criteria = builder.createQuery(Boutique.class);
        Root<Boutique> from = criteria.from(Boutique.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("chiffreVente"), chiffreVente));
        TypedQuery<Boutique> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Boutique> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Boutique> cq = cb.createQuery(Boutique.class);
        TypedQuery<Boutique> allQuery = entityManager.createQuery(cq.select(cq
                .from(Boutique.class)));

        return allQuery.getResultList();
    }
}