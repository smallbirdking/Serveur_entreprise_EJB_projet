package fr.unice.polytech.se.demo.domain.impl;

/**
 * Created by user on 31/03/15.
 */


import fr.unice.polytech.se.demo.domain.BoutiqueFinder;
import fr.unice.polytech.se.demo.domain.BoutiqueManager;
import fr.unice.polytech.se.demo.entities.Boutique;
import fr.unice.polytech.se.demo.entities.Recette;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sth on 3/24/15.
 */
@Stateless
public class BoutiqueManagerBean implements BoutiqueManager {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    BoutiqueFinder finder;



    @Override
    public Boutique create(Recette recette_du_jour, String addresseBoutique, double tax, Integer chiffreVente) {
        Boutique boutique = finder.findByAddresse(addresseBoutique);
        if (boutique == null){
            boutique = new Boutique();
            boutique.setAddresseBoutique(addresseBoutique);
            boutique.setChiffreVente(chiffreVente);
            boutique.setTax(tax);
            //boutique.setRecette_du_jour(recette_du_jour);
            entityManager.persist(boutique);
        }
        return boutique;
    }
}