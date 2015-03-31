package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.CommandeFinder;
import fr.unice.polytech.se.demo.domain.CommandeManager;
import fr.unice.polytech.se.demo.entities.Commande;
import fr.unice.polytech.se.demo.entities.Recette;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * Created by user on 31/03/15.
 */
@Stateless
public class CommandeManagerBean implements CommandeManager {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    CommandeFinder finder;

    @Override
    public Commande create(Date date, Integer quantite) {
        Commande c = new Commande(date, quantite);
        entityManager.persist(c);
        return c;
    }

    @Override
    public void addRecette(String recette, double taxe, long id) {
        Commande toUpdate = finder.findById(id);
        Recette r = new Recette(recette,taxe);
       // toUpdate.addRecette(r);
    }

    @Override
    public Commande create() {
        return null;
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Initializing CommandMgr");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Destroying CommandMgr");
    }

}
