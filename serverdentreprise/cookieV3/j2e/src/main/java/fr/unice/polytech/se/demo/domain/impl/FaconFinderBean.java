package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.FaconFinder;
import fr.unice.polytech.se.demo.entities.Facon;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by user on 07/04/15.
 */
@Stateless
public class FaconFinderBean implements FaconFinder {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Facon findById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Facon> criteria = builder.createQuery(Facon.class);
        Root<Facon> from = criteria.from(Facon.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("id"), id));
        TypedQuery<Facon> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Facon findByName(String n) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Facon> criteria = builder.createQuery(Facon.class);
        Root<Facon> from = criteria.from(Facon.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("nom_Facon"), n));
        TypedQuery<Facon> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Facon findByTemps(double time) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Facon> criteria = builder.createQuery(Facon.class);
        Root<Facon> from = criteria.from(Facon.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("temps_Utilise"), time));
        TypedQuery<Facon> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Facon> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Facon> cq = cb.createQuery(Facon.class);
        TypedQuery<Facon> allQuery = entityManager.createQuery(cq.select(cq
                .from(Facon.class)));

        return allQuery.getResultList();
    }
}
