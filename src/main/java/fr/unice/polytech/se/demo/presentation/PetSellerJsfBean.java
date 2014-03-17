package fr.unice.polytech.se.demo.presentation;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import fr.unice.polytech.se.demo.domain.PetFinder;
import fr.unice.polytech.se.demo.domain.PetManager;
import fr.unice.polytech.se.demo.entities.Pet;

@ManagedBean
public class PetSellerJsfBean {

	@EJB
	private PetFinder petFinder;

	@EJB
	private PetManager petManager;

	private String petName;

	private String errorMessage;

	public String add() {
		if (petName != null && !petName.trim().isEmpty()) {
			petManager.create(petName);
			return "success";
		}

		this.errorMessage = "Pet name must not be empty!";
		return "fail";
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public String getPetName() {
		return petName;
	}

	public List<Pet> getPets() {
		return petFinder.findAll();
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

}
