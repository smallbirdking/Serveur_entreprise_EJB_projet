package fr.unice.polytech.se.demo;

import fr.unice.polytech.se.demo.domain.RecetteFinder;
import fr.unice.polytech.se.demo.domain.RecetteManager;
import fr.unice.polytech.se.demo.domain.impl.RecetteManagerBean;
import fr.unice.polytech.se.demo.entities.Recette;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 01/04/15.
 */
@RunWith(Arquillian.class)

public class RecetteManagerTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Recette.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
                .addPackage(RecetteManager.class.getPackage())
                .addPackage(RecetteManagerBean.class.getPackage());
    }

    @EJB
    private RecetteManager manager;

    @EJB
    private RecetteFinder finder;

    @Test
    public void testCreation()  {
        // Boutique boutique = manager.create("Polytech",new Date(1000),new Date(2000),100);
        Recette Recette=manager.create("Chocolect", 10);
        //assertEquals(Commande.getAddresseBoutique(), "Polytech");
        //Commande found = finder.findAll().get(0);
        //assertEquals(found.getId(), commande.getId());
        Recette found = finder.findByName("Chocolect");
        assertEquals(found.getNom_recette(), Recette.getNom_recette());
       assertEquals(found.getId(), Recette.getId());
    }

}
