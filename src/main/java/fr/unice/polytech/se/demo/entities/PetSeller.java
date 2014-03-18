package fr.unice.polytech.se.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class PetSeller implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private Set<PetCard> cards = new HashSet<PetCard>();

	public PetSeller() {

	}

	public PetSeller(String name) {
		super();
		this.name = name;
	}

	public void add(PetCard petCard) {
		this.cards.add(petCard);
		petCard.setPetSeller(this);
	}

	public void remove(PetCard petCard) {
		this.cards.remove(petCard);
		petCard.setPetSeller(null);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@NotNull
	public String getName() {
		return name;
	}

	@OneToMany(mappedBy = "petSeller")
	public Set<PetCard> getCards() {
		return cards;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCards(Set<PetCard> cards) {
		this.cards = cards;
	}

}
