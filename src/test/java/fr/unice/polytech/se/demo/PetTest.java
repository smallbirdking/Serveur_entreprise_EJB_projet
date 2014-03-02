package fr.unice.polytech.se.demo;

import fr.unice.polytech.se.demo.entities.*;
import junit.framework.TestCase;

import javax.annotation.Resource;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.Properties;


public class PetTest extends TestCase {

	@PersistenceContext
	private EntityManager manager;

	@Resource
	private UserTransaction transaction;

	public void setUp() throws Exception {
		Properties p = new Properties();
		p.put("petDatabase", "new://Resource?type=DataSource");
		p.put("petDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("petDatabase.JdbcUrl", "jdbc:hsqldb:mem:petdb");

		EJBContainer.createEJBContainer(p).getContext().bind("inject", this);
	}


	public void testAdd() throws Exception {
		Pet p = new Pet("Jinx");
		Pet d = new Pet("Dummy") ;
		transaction.begin();
		try {
			manager.persist(p);
			assertTrue(manager.contains(p));
			assertFalse(manager.contains(new Pet("Jinx")));
			assertFalse(manager.contains(d));
		} finally {
			transaction.commit();
		}
	}

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
			assertEquals(result.size(),1);
		} finally {
			transaction.commit();
		}
	}

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
			assertEquals(result.size(),0);
		} finally {
			transaction.commit();
		}
	}


}