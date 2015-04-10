package fr.unice.polytech.se.demo;

import fr.unice.polytech.se.demo.domain.BoutiqueFinder;
import fr.unice.polytech.se.demo.domain.BoutiqueManager;
import fr.unice.polytech.se.demo.domain.RecetteManager;
import fr.unice.polytech.se.demo.domain.impl.BoutiqueManagerBean;
import fr.unice.polytech.se.demo.entities.Boutique;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by user on 01/04/15.
 */

@RunWith(Arquillian.class)
public class BoutiqueManagerTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Boutique.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
                .addPackage(BoutiqueManager.class.getPackage())
                .addPackage(BoutiqueManagerBean.class.getPackage());
    }

    @EJB

    private BoutiqueManager managerB;

    @EJB
    private RecetteManager managerR;

    @EJB
    private BoutiqueFinder finder;

    @Test
    public void testCreation()  {
         //Boutique boutique = manager.create("Polytech",new Date(1000),new Date(2000),100);


        //Recette recette =managerR.create("Chocolect", 10,10);

        //Recette recette=new Recette("Chocolect", 10,10);

        Boutique boutique = managerB.create("Polytech",100,10,9,5);
        //assertEquals(Commande.getAddresseBoutique(), "Polytech");
        //Commande found = finder.findAll().get(0);
        //assertEquals(found.getId(), commande.getId());
        Boutique found = finder.findAll().get(0);
        assertEquals(found.getAddresseBoutique(), boutique.getAddresseBoutique());
        assertEquals(found.getId(), boutique.getId());
    }



}
