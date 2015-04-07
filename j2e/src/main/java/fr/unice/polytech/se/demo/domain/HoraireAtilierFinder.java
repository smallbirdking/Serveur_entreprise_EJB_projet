package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.HoraireAtlier;

import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 31/03/15.
 */
public interface HoraireAtilierFinder {
    public HoraireAtlier findById(int  n);

    public List<HoraireAtlier> findByIdBoutique(int  c);

    public HashMap<Integer,HoraireAtlier> findByInterval(int  c);

    public List<HoraireAtlier> findAll();
}
