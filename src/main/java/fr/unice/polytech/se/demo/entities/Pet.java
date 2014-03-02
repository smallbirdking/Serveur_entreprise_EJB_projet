package fr.unice.polytech.se.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="PET")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "PET_NAME")
	@NotNull
	public String name;

	public Pet() {}

	public Pet(String n) {
		this.name = n;
	}

	public String toString(){
		return "Pet[" + this.id + "]#" + this.name;
	}
}
