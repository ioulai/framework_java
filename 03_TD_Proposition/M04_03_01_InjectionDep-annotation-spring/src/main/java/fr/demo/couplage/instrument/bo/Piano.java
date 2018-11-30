package fr.demo.couplage.instrument.bo;

import org.springframework.stereotype.Component;

/**
 * Business Object : BO.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
@Component
public class Piano implements Instrument {

    @Override
    public void afficher() {
        System.out.println("Je suis un piano...");
    }

    @Override
    public void jouer() {
        System.out.println("TING TING TING !");
    }
}
