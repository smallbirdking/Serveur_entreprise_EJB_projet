package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.InfoPaymentManager;
import fr.unice.polytech.se.demo.entities.InfoPayment;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by user on 07/04/15.
 */
@Stateless
public class InfoPaymentManagerBean implements InfoPaymentManager{
    @PersistenceContext
    EntityManager entityManager;

    @EJB
    InfoPayment finder ;


    @Override
    public InfoPayment create(String nc, String ac, String cb) {

        InfoPayment c=new InfoPayment(nc,ac,cb);
        entityManager.persist(c);

        return c;
    }
}
