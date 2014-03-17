package fr.unice.polytech.se.demo.domain.impl;

import java.util.List;

import fr.unice.polytech.se.demo.domain.PetFinder;
import fr.unice.polytech.se.demo.entities.Pet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * demo
 * mosser (10/03/2014, 23:07)
 */
@Stateless
public class PetFinderBean implements PetFinder {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Pet findByName(String n) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pet> criteria = builder.createQuery(Pet.class);
		Root<Pet> from = criteria.from(Pet.class);
		criteria.select(from);
		criteria.where(builder.equal(from.get("name"), n));
		TypedQuery<Pet> query = entityManager.createQuery(criteria);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Pet> findAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pet> cq = cb.createQuery(Pet.class);
        TypedQuery<Pet> allQuery = entityManager.createQuery(cq.select(cq.from(Pet.class)));
        
        return allQuery.getResultList();
	}
	
}
