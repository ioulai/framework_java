package fr.demo.couplage.app;

import fr.demo.couplage.business.Orchestre;
import fr.demo.couplage.musicien.bo.Pianiste;
import fr.demo.couplage.musicien.bo.Violoniste;

/**
 * Demonstration de code avec un couplage FORT.
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

        Pianiste p1 = new Pianiste("Beethoven");
        p1.jouerMorceau();

        Violoniste v1 = new Violoniste("Beethoven");
        v1.jouerMorceau();

        System.out.println("\n>>> Orchestre :");
        Orchestre o1 = new Orchestre();
        o1.add(p1);
        o1.add(v1);

        o1.jouer();

    }
}
