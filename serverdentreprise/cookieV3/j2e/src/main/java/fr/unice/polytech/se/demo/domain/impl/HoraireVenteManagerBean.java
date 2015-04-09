package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.HoraireVenteFinder;
import fr.unice.polytech.se.demo.domain.HoraireVenteManager;
import fr.unice.polytech.se.demo.entities.HoraireVente;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by user on 07/04/15.
 */
@Stateless
public class HoraireVenteManagerBean implements HoraireVenteManager {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    HoraireVenteFinder finder ;


    @Override
    public HoraireVente create() {

        HoraireVente c=new HoraireVente();
        entityManager.persist(c);

        return c;
    }
}
