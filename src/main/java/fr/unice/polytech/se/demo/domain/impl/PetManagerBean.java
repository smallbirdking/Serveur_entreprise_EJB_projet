package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.PetFinder;
import fr.unice.polytech.se.demo.domain.PetManager;
import fr.unice.polytech.se.demo.entities.Pet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 * demo
 * mosser (10/03/2014, 22:19)
 */
@Stateless
public class PetManagerBean implements PetManager {

	@PersistenceContext
	EntityManager entityManager;

	@EJB
	PetFinder finder;

	@Override
	public Pet create(String name) {
		Pet r = finder.findByName(name);
		if (r == null) {
			r = new Pet(name);
			entityManager.persist(r);
		}
		return r;
	}

	@PostConstruct
	public void initialize() {
		System.out.println("Initializing PetManager");
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("Destroying PetManager");
	}
}
