package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.Boutique;
import fr.unice.polytech.se.demo.entities.Recette;

/**
 * Created by user on 31/03/15.
 */
public interface BoutiqueManager {
    public Boutique create(Recette recette_du_jour, String addresseBoutique, double tax, Integer chiffreVente);
    public Boutique create(String addresseBoutique, double tax, Integer chiffreVente, int tempsOuv, int tempsFer);
}
