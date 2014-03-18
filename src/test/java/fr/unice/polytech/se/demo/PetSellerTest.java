package fr.unice.polytech.se.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.unice.polytech.se.demo.entities.Pet;
import fr.unice.polytech.se.demo.entities.PetCard;
import fr.unice.polytech.se.demo.entities.PetSeller;

@RunWith(Arquillian.class)
public class PetSellerTest {

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addPackage(PetSeller.class.getPackage())
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource("META-INF/persistence.xml",
						"persistence.xml");
	}

	@PersistenceContext
	EntityManager manager;

	@Inject
	UserTransaction transaction;

	@Test
	public void testAdd() throws Exception {
		List<Pet> pets = new ArrayList<Pet>();
		List<PetCard> petCards = new ArrayList<PetCard>();

		int nbPets = 10;

		for (int i = 1; i <= nbPets; i++) {
			String type = ((i % 2 == 0) ? "cat" : "dog");

			pets.add(new Pet(type + i));
		}

		for (int i = 1; i <= nbPets; i++) {
			PetCard petCard = new PetCard(pets.get(i - 1),
					BigDecimal.valueOf(499.99 - (i * 10)), "Very nice "
							+ ((i % 2 == 0) ? "cat" : "dog")
							+ " that love to jump on keyboards"
							+ System.currentTimeMillis());
			petCards.add(petCard);
		}

		PetSeller seller = new PetSeller("PetPet");

		for (int i = 0; i < petCards.size(); i++) {
			seller.add(petCards.get(i));
		}

		transaction.begin();
		try {
			for (int i = 0; i < pets.size(); i++) {
				manager.persist(pets.get(i));
				manager.persist(petCards.get(i));
			}
			manager.persist(seller);

			for (int i = 0; i < pets.size(); i++) {
				Assert.assertTrue(manager.contains(pets.get(i)));
				Assert.assertTrue(manager.contains(petCards.get(i)));
			}

			Assert.assertTrue(manager.contains(seller));

			Assert.assertFalse(manager.contains(new Pet("Jinx")));
		} finally {
			transaction.commit();
		}
	}

	@Test
	public void testRetrieveCats() throws Exception {
		transaction.begin();
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<PetCard> criteria = builder
					.createQuery(PetCard.class);
			Root<PetCard> from = criteria.from(PetCard.class);
			criteria.select(from);
			criteria.where(builder.like(
					from.<Pet> get("pet").<String> get("name"), "cat%"));
			criteria.orderBy(builder.desc(from.get("price")));

			TypedQuery<PetCard> query = manager.createQuery(criteria);

			List<PetCard> result = query.getResultList();
			Assert.assertEquals(5, result.size());

			PetCard last = result.get(0);

			for (int i = 0; i < result.size(); i++) {
				if (i > 0) {
					Assert.assertTrue(last.getPrice().compareTo(
							result.get(i).getPrice()) >= 0);
				}

				Assert.assertTrue(result.get(i).getPet().name.startsWith("cat"));

				last = result.get(i);
			}
		} finally {
			transaction.commit();
		}
	}

}
