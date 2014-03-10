package fr.unice.polytech.se.demo;

import fr.unice.polytech.se.demo.domain.PetFinder;
import fr.unice.polytech.se.demo.domain.PetManager;
import fr.unice.polytech.se.demo.domain.impl.PetManagerBean;
import fr.unice.polytech.se.demo.entities.Pet;
import fr.unice.polytech.se.demo.entities.PetSeller;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import static  org.junit.Assert.*;
import javax.ejb.EJB;

/**
 * demo
 * mosser (10/03/2014, 22:22)
 */
@RunWith(Arquillian.class)
public class PetManagerTest {

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackage(PetSeller.class.getPackage())
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
				.addPackage(PetManager.class.getPackage())
				.addPackage(PetManagerBean.class.getPackage());
	}


	@EJB
	private PetManager manager;

	@EJB
	private PetFinder finder;

	@Test
	public void testCreation()  {
		Pet jinx = manager.create("Jinx");
		assertEquals(jinx.name, "Jinx");
		Pet found = finder.findByName("Jinx");
		assertEquals(found, jinx);
	}

	/**
	 * demo
	 * mosser (10/03/2014, 23:52)
	 */
	public static class PetCartBeanTest {
	}
}
