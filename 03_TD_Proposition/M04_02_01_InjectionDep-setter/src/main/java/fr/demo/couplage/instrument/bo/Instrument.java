package fr.demo.couplage.instrument.bo;

/**
 * Cette interface est utilisée comme un type. Elle permet la généralisation des obj.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
public interface Instrument {

    /**
     * Afficher qui je suis.
     */
    public void afficher();

    /**
     * Jouer un instrument.
     */
    public void jouer();

}
