package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.InfoPayment;

import java.util.List;

/**
 * Created by user on 07/04/15.
 */
public interface InfoPaymentFinder {
    public InfoPayment findById(long id);

    public InfoPayment findByNomClient(String c);

    public InfoPayment findByaddresseClient(String a);

    public List<InfoPayment> findAll();
}
