package fr.demo.couplage.app;

import fr.demo.couplage.business.Orchestre;
import fr.demo.couplage.instrument.bo.Piano;
import fr.demo.couplage.instrument.bo.Violon;
import fr.demo.couplage.musicien.bo.Musicien;

/**
 * Demonstration de code avec un couplage FAIBLE.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
public class CouplageApp {

    /**
     * MainEntry.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Musicien m1 = new Musicien("Beethoven", new Piano());
        m1.jouerMorceau();

        Musicien m2 = new Musicien("Beethoven", new Violon());
        m2.jouerMorceau();

        System.out.println("\n>>> Orchestre :");
        Orchestre o1 = new Orchestre();
        o1.add(m1);
        o1.add(m2);

        o1.jouer();

    }
}
