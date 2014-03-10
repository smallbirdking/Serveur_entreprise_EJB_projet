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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "PET_NAME")
    @NotNull
    public String name;

    public Pet() {
    }

    public Pet(String n) {
        this.name = n;
    }

    public String toString() {
        return "Pet[" + this.id + "]#" + this.name;
    }

	public boolean equals(Object o) {
		if (o instanceof Pet) {
			Pet that = (Pet) o;
			return that.name.equals(this.name);
		}
		return false;
	}

}
