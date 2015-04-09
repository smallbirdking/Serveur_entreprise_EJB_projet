package fr.unice.polytech.se.demo.domain.impl;

import fr.unice.polytech.se.demo.domain.CommandeCart;
import fr.unice.polytech.se.demo.entities.Commande;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 01/04/15.
 */

@Stateless
public class CommandeCartBean implements CommandeCart {

    private ArrayList<Commande> _contents = new ArrayList<Commande>();

    @Override
    public void addCommande(Commande c) {
        _contents.add(c);
    }

    @Override
    public void deleteCommande(Commande c) {
        _contents.remove(c);
    }

    @Override
    public List<Commande> getContents() {
        return _contents;
    }
}
