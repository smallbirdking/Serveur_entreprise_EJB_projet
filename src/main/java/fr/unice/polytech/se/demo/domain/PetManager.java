package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Pet;

import javax.ejb.Local;

/**
 * demo
 * mosser (10/03/2014, 22:20)
 */
public interface PetManager {
	public Pet create(String name);
}
