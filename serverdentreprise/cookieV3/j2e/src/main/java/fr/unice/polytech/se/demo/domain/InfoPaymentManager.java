package fr.unice.polytech.se.demo.domain;

import fr.unice.polytech.se.demo.entities.InfoPayment;

/**
 * Created by user on 07/04/15.
 */
public interface InfoPaymentManager {
    public InfoPayment create(String nc, String ac, String cb);
}
