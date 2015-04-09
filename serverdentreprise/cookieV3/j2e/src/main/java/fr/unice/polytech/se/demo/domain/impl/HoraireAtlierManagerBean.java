package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.HoraireAtlierFinder;
import fr.unice.polytech.se.demo.domain.HoraireAtlierManager;
import fr.unice.polytech.se.demo.entities.HoraireAtlier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by user on 07/04/15.
 */
@Stateless
public class HoraireAtlierManagerBean implements HoraireAtlierManager {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    HoraireAtlierFinder finder ;


    @Override
    public HoraireAtlier create() {

        HoraireAtlier c=new HoraireAtlier();
        entityManager.persist(c);

        return c;
    }
}