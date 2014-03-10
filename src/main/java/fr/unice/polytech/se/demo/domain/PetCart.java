package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Pet;

import java.util.List;

/**
 * demo
 * mosser (10/03/2014, 23:46)
 */
public interface PetCart {

	public void addPet(Pet p);

	public List<Pet> getContents();

}
