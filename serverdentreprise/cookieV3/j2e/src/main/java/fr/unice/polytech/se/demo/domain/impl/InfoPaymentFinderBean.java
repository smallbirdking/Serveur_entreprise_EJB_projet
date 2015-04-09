package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.InfoPaymentFinder;
import fr.unice.polytech.se.demo.entities.InfoPayment;

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
public class InfoPaymentFinderBean implements InfoPaymentFinder{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public InfoPayment findById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<InfoPayment> criteria = builder.createQuery(InfoPayment.class);
        Root<InfoPayment> from = criteria.from(InfoPayment.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("id"), id));
        TypedQuery<InfoPayment> query = entityManager.createQuery(criteria.select(criteria
                .from(InfoPayment.class)));
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public InfoPayment findByNomClient(String c) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<InfoPayment> criteria = builder.createQuery(InfoPayment.class);
        Root<InfoPayment> from = criteria.from(InfoPayment.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("nom_Client"), c));
        TypedQuery<InfoPayment> query = entityManager.createQuery(criteria.select(criteria
                .from(InfoPayment.class)));
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public InfoPayment findByaddresseClient(String a) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<InfoPayment> criteria = builder.createQuery(InfoPayment.class);
        Root<InfoPayment> from = criteria.from(InfoPayment.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("addresse_Client"), a));
        TypedQuery<InfoPayment> query = entityManager.createQuery(criteria.select(criteria
                .from(InfoPayment.class)));
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<InfoPayment> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<InfoPayment> cq = cb.createQuery(InfoPayment.class);
        TypedQuery<InfoPayment> allQuery = entityManager.createQuery(cq.select(cq
                .from(InfoPayment.class)));

        return allQuery.getResultList();
    }
}
