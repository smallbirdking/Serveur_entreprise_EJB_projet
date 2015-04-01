package fr.unice.polytech.se.demo;

import fr.unice.polytech.se.demo.domain.BoutiqueFinder;
import fr.unice.polytech.se.demo.domain.BoutiqueManager;
import fr.unice.polytech.se.demo.domain.RecetteManager;
import fr.unice.polytech.se.demo.domain.impl.RecetteManagerBean;
import fr.unice.polytech.se.demo.entities.Boutique;
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
public class BoutiqueManagerTest {
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
    private BoutiqueManager managerB;

    @EJB
    private RecetteManager managerR;

    @EJB
    private BoutiqueFinder finder;

    @Test
    public void testCreation()  {
        // Boutique boutique = manager.create("Polytech",new Date(1000),new Date(2000),100);


        Recette recette =managerR.create("Chocolect", 10,10);

       // Recette r=new Recette("Chocolect", 10);

        Boutique boutique = managerB.create(recette,"Polytech",100,10);
        //assertEquals(Commande.getAddresseBoutique(), "Polytech");
        //Commande found = finder.findAll().get(0);
        //assertEquals(found.getId(), commande.getId());
        Boutique found = finder.findAll().get(0);
        assertEquals(found.getAddresseBoutique(), boutique.getAddresseBoutique());
        assertEquals(found.getId(), boutique.getId());
    }

}
