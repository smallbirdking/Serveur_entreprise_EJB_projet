package fr.unice.polytech.se.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PET")
public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long id;

	public String name;

	public Pet() {
	}

	public Pet(String n) {
		this.name = n;
	}

	public String toString() {
		return "Pet[" + this.id + "]#" + this.name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "PET_NAME")
	@NotNull
	public String getName() {
		return name;
	}

	public boolean equals(Object o) {
		if (o instanceof Pet) {
			Pet that = (Pet) o;
			return that.name.equals(this.name);
		}
		return false;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
