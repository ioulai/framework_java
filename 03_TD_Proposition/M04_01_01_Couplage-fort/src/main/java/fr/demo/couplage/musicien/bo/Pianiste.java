package fr.demo.couplage.musicien.bo;

import fr.demo.couplage.instrument.bo.Piano;

/**
 * Business Object : BO.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
public class Pianiste {

    private Piano piano;
    private String morceau;

    public Pianiste(String morceau) {
        super();
        this.morceau = morceau;
        this.piano = new Piano();
    }

    public void jouerMorceau() {
        piano.afficher();
        System.out.println("je joue le morceau ".concat(morceau));
        piano.jouer();
    }
}
