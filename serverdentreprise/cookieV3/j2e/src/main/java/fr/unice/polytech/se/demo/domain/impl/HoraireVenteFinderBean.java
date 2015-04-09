package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.HoraireVenteFinder;
import fr.unice.polytech.se.demo.entities.HoraireVente;

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
public class HoraireVenteFinderBean implements HoraireVenteFinder{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public HoraireVente findById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HoraireVente> criteria = builder.createQuery(HoraireVente.class);
        Root<HoraireVente> from = criteria.from(HoraireVente.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("id"), id));
        TypedQuery<HoraireVente> query = entityManager.createQuery(criteria.select(criteria
                .from(HoraireVente.class)));
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<HoraireVente> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HoraireVente> cq = cb.createQuery(HoraireVente.class);
        TypedQuery<HoraireVente> allQuery = entityManager.createQuery(cq.select(cq
                .from(HoraireVente.class)));

        return allQuery.getResultList();
    }
}
