package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.CommandeFinder;
import fr.unice.polytech.se.demo.entities.Commande;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 31/03/15.
 */
@Stateless
public class CommandeFinderBean implements CommandeFinder {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Commande findById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Commande> criteria = builder.createQuery(Commande.class);
        Root<Commande> from = criteria.from(Commande.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("id_Commande"), id));
        TypedQuery<Commande> query = entityManager.createQuery(criteria.select(criteria
                .from(Commande.class)));
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Commande> findByDate(Date date) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Commande> criteria = builder.createQuery(Commande.class);
        Root<Commande> from = criteria.from(Commande.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("date"), date));
        TypedQuery<Commande> query = entityManager.createQuery(criteria.select(criteria
                .from(Commande.class)));
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public List<Commande> findByQuantite (int quantite) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Commande> criteria = builder.createQuery(Commande.class);
        Root<Commande> from = criteria.from(Commande.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("quantite"), quantite));
        TypedQuery<Commande> query = entityManager.createQuery(criteria.select(criteria
                .from(Commande.class)));
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Commande> findByIdBoutique(long IdBoutique) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Commande> criteria = builder.createQuery(Commande.class);
        Root<Commande> from = criteria.from(Commande.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("IdBoutique"), IdBoutique));
        TypedQuery<Commande> query = entityManager.createQuery(criteria.select(criteria
                .from(Commande.class)));
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Commande> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Commande> cq = cb.createQuery(Commande.class);
        TypedQuery<Commande> allQuery = entityManager.createQuery(cq.select(cq
                .from(Commande.class)));

        return allQuery.getResultList();
    }
}