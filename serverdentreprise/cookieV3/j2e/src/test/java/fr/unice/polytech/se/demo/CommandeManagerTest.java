package fr.unice.polytech.se.demo;

import fr.unice.polytech.se.demo.domain.*;
import fr.unice.polytech.se.demo.domain.impl.CommandeManagerBean;
import fr.unice.polytech.se.demo.entities.Boutique;
import fr.unice.polytech.se.demo.entities.Commande;
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
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 01/04/15.
 */
@RunWith(Arquillian.class)
public class CommandeManagerTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Commande.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
                .addPackage(CommandeManager.class.getPackage())
                .addPackage(CommandeManagerBean.class.getPackage());
    }

    @EJB
    private CommandeManager managerC;

    @EJB
    private RecetteManager managerR;

    @EJB
    private CommandeFinder finderC;

    @EJB
    private RecetteFinder finderR;

    @EJB
    private BoutiqueManager manager;

    @Test
    public void testCreation()  {
        Recette recette = managerR.create("Chocolate", 10, 10);
        Boutique boutique = manager.create(recette,"Polytech",100,10);
        //Recette recette=new Recette("Chocolate",10,10); B

       // Recette recette= finderR.findByName("Chocolect");

        Commande commande=managerC.create(recette,new Date(0,0,0), 10);


        //commande.setRecette(recette);
        //assertEquals(Commande.getAddresseBoutique(), "Polytech");
        //Commande found = finder.findAll().get(0);
        //assertEquals(found.getId(), commande.getId());
        Commande found = finderC.findAll().get(0);
        assertEquals(found.getQuantite(), commande.getQuantite());
        assertEquals(found.getId(), commande.getId());
    }

}
