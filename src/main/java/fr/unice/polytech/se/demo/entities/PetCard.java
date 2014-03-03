package fr.unice.polytech.se.demo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class PetCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PetSeller petSeller;

    @OneToOne
    public Pet pet;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime = new Date();

    @NotNull
    public BigDecimal price;

    @NotNull
    public String description;

    public PetCard() {

    }

    public PetCard(Pet pet, BigDecimal price, String description) {
        super();
        this.pet = pet;
        this.price = price;
        this.description = description;
    }

    public void setPetSeller(PetSeller petSeller) {
        this.petSeller = petSeller;
    }

}
