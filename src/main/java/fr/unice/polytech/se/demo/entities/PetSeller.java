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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotNull
    public String name;

    @OneToMany(mappedBy = "petSeller")
    public Set<PetCard> cards = new HashSet<PetCard>();

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

}
