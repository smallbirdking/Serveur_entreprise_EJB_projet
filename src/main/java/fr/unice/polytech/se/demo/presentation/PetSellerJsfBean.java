package fr.unice.polytech.se.demo.presentation;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fr.unice.polytech.se.demo.domain.PetFinder;
import fr.unice.polytech.se.demo.domain.PetManager;
import fr.unice.polytech.se.demo.entities.Pet;

@ManagedBean
public class PetSellerJsfBean {

	private static final int PAGINATION_QUANTITY = 5;

	@EJB
	private PetFinder petFinder;

	@EJB
	private PetManager petManager;

	private String petName;

	private String errorMessage;

	private int paginationStartIndex = 0;

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

	public int getPaginationStartIndex() {
		return paginationStartIndex;
	}

	public int getNextPaginationIndex() {
		return paginationStartIndex + PAGINATION_QUANTITY;
	}

	public int getPreviousPaginationIndex() {
		return Math.max(0, paginationStartIndex - PAGINATION_QUANTITY);
	}

	public String getPetName() {
		return petName;
	}

	public List<Pet> getPets() {
		Map<String, String> parameters = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();

		int startIndex = -1;

		try {
			startIndex = Integer.parseInt(parameters.get("start"));
		} catch (NumberFormatException e) {
		}

		if (startIndex > -1) {
			paginationStartIndex = startIndex;
		}

		return petFinder.findLast(PAGINATION_QUANTITY, paginationStartIndex);
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

}
