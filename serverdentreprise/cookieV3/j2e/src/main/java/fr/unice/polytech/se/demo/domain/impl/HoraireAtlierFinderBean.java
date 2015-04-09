package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.HoraireAtlierFinder;
import fr.unice.polytech.se.demo.entities.HoraireAtlier;

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
public class HoraireAtlierFinderBean implements HoraireAtlierFinder {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public HoraireAtlier findById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HoraireAtlier> criteria = builder.createQuery(HoraireAtlier.class);
        Root<HoraireAtlier> from = criteria.from(HoraireAtlier.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("id"), id));
        TypedQuery<HoraireAtlier> query = entityManager.createQuery(criteria.select(criteria
                .from(HoraireAtlier.class)));
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<HoraireAtlier> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HoraireAtlier> cq = cb.createQuery(HoraireAtlier.class);
        TypedQuery<HoraireAtlier> allQuery = entityManager.createQuery(cq.select(cq
                .from(HoraireAtlier.class)));

        return allQuery.getResultList();
    }
}