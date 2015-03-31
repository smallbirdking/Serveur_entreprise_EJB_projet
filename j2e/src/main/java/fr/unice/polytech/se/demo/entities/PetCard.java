package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class PetCard implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private PetSeller petSeller;

	private Pet pet;

	private Date creationTime = new Date();

	private BigDecimal price;

	private String description;

	public PetCard() {

	}

	public PetCard(Pet pet, BigDecimal price, String description) {
		super();
		this.pet = pet;
		this.price = price;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public PetSeller getPetSeller() {
		return petSeller;
	}

	@OneToOne
	public Pet getPet() {
		return pet;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationTime() {
		return creationTime;
	}

	@NotNull
	public BigDecimal getPrice() {
		return price;
	}

	@NotNull
	public String getDescription() {
		return description;
	}

	public void setPetSeller(PetSeller petSeller) {
		this.petSeller = petSeller;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
