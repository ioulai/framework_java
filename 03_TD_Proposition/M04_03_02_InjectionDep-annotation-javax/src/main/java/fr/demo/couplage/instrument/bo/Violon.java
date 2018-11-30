package fr.demo.couplage.instrument.bo;

import javax.inject.Named;

/**
 * Business Object : BO.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
@Named(value = "violon")
public class Violon implements Instrument {

    @Override
    public void afficher() {
        System.out.println("Je suis un violon...");
    }

    @Override
    public void jouer() {
        System.out.println("ZIN ZIN ZIN !");
    }
}
