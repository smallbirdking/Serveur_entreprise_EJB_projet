package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.HoraireVente;

import java.util.List;

/**
 * Created by user on 07/04/15.
 */
public interface HoraireVenteFinder {
    public HoraireVente findById(long id);

    //public List<HoraireAtlier> findByIdBoutique(int  c);

    //public HashMap<Integer,HoraireAtlier> findByInterval(int  c);

    public List<HoraireVente> findAll();
}
