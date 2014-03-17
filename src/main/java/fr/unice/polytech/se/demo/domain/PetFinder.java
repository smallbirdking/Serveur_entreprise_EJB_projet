package fr.unice.polytech.se.demo.domain;

import java.util.List;

import fr.unice.polytech.se.demo.entities.Pet;

/**
 * demo
 * mosser (10/03/2014, 23:06)
 */
public interface PetFinder {

	public Pet findByName(String n);

	public List<Pet> findAll();
	
}
