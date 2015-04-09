package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.FaconFinder;
import fr.unice.polytech.se.demo.domain.FaconManager;
import fr.unice.polytech.se.demo.entities.Facon;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by user on 07/04/15.
 */
@Stateless
public class FaconManagerBean implements FaconManager{
    @PersistenceContext
    EntityManager entityManager;

    @EJB
    FaconFinder finder;

    @Override
    public Facon create(String name,double time) {
        Facon i=finder.findByName(name);
        if(i==null) {
            i = new Facon(name, time);
        }
        entityManager.persist(i);
        return i;
    }
}
