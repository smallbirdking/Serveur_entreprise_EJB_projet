package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.PetCart;
import fr.unice.polytech.se.demo.entities.Pet;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

/**
 * demo
 * mosser (10/03/2014, 23:47)
 */
@Stateful
public class PetCartBean implements PetCart {

	private ArrayList<Pet> _contents = new ArrayList<Pet>();

	@Override
	public void addPet(Pet p) {
		_contents.add(p);
	}

	@Override
	public List<Pet> getContents() {
		return _contents;
	}
}
