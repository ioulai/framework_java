package fr.demo.couplage.instrument.bo;

import javax.inject.Named;

/**
 * Business Object : BO.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
@Named(value = "piano")
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
