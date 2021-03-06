package fr.demo.couplage.musicien.bo;

import fr.demo.couplage.instrument.bo.Instrument;

/**
 * Business Object : BO.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
public class Musicien {

    private Instrument instrument;
    private String morceau;

    public Musicien(String morceau, Instrument instrument) {
        super();
        this.morceau = morceau;
        this.instrument = instrument;
    }

    public void jouerMorceau() {
        instrument.afficher();
        System.out.println("je joue le morceau ".concat(morceau));
        instrument.jouer();
    }
}
