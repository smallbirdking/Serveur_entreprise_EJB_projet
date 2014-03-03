package fr.unice.polytech.se.demo;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.unice.polytech.se.demo.entities.Pet;


public class PetTest {

	@PersistenceContext
	private EntityManager manager;

	@Resource
	private UserTransaction transaction;

	private EJBContainer container;

	@Before
	public void setUp() throws Exception {
		Properties p = new Properties();
		p.put("petDatabase", "new://Resource?type=DataSource");
		p.put("petDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("petDatabase.JdbcUrl", "jdbc:hsqldb:mem:petdb");

		container = EJBContainer.createEJBContainer();
		container.getContext().bind("inject", this);
	}

	@After
	public void tearDown() {
		container.close();
	}

	@Test
	public void testAdd() throws Exception {
		Pet p = new Pet("Jinx");
		Pet d = new Pet("Dummy") ;
		transaction.begin();
		try {
			manager.persist(p);
			Assert.assertTrue(manager.contains(p));
			Assert.assertFalse(manager.contains(new Pet("Jinx")));
			Assert.assertFalse(manager.contains(d));
		} finally {
			transaction.commit();
		}
	}

	@Test
	public void testRetrieveByName() throws Exception {
		transaction.begin();
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Pet> criteria = builder.createQuery(Pet.class);
			Root<Pet> from = criteria.from(Pet.class) ;
			criteria.select(from);
			criteria.where(builder.equal(from.get("name"), "Jinx"));
			TypedQuery<Pet> query = manager.createQuery(criteria);

			List<Pet> result =  query.getResultList();
			Assert.assertEquals(1, result.size());
		} finally {
			transaction.commit();
		}
	}

	@Test
	public void testRetrieveUnknown() throws Exception {
		transaction.begin();
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Pet> criteria = builder.createQuery(Pet.class);
			Root<Pet> from = criteria.from(Pet.class) ;
			criteria.select(from);
			criteria.where(builder.equal(from.get("name"), "Dummy"));
			TypedQuery<Pet> query = manager.createQuery(criteria);

			List<Pet> result =  query.getResultList();
			Assert.assertEquals(0, result.size());
		} finally {
			transaction.commit();
		}
	}


}