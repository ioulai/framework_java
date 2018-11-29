package fr.demo.couplage.musicien.bo;

import fr.demo.couplage.instrument.bo.Violon;

/**
 * Business Object : BO.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
public class Violoniste {

    private Violon violon;
    private String morceau;

    public Violoniste(String morceau) {
        super();
        this.morceau = morceau;
        this.violon = new Violon();
    }

    public void jouerMorceau() {
        violon.afficher();
        System.out.println("je joue le morceau ".concat(morceau));
        violon.jouer();
    }
}
