package fr.unice.polytech.se.demo.domain.impl;

import java.util.Date;

/**
 * Created by user on 31/03/15.
 */
public class ProcessCommand {
    CommandeCartBean cm = new CommandeCartBean();
   // IngredientManagerBean im = new IngredientManagerBean();
   // RecetteManagerBean rm = new RecetteManagerBean();
    //String owner ;
    ProcessCommand(Date date,Integer i,String magasin){
       // cm.create();
        //this.owner= owner;
        //TODO lier au magasin
    }
    /*void ajouterIngredient(String name)
    {
        rm.addIngredientToRecette(name,owner);
    }

    void ajouter(String name)
    {
        rm.addIngredientToRecette(name,owner);
    }


    void deleteIngredient(String name)
    {
        rm.deleteIngredientToRecette(name,owner);
    }

    void validate()
    {
        Commande c= cm.findByOwner(owner).get(0);
        c.generateCommand(0);
    }*/
}
