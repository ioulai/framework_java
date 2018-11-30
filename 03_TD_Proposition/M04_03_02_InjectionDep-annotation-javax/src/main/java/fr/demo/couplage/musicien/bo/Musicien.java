package fr.demo.couplage.musicien.bo;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

import fr.demo.couplage.instrument.bo.Instrument;

/**
 * Business Object : BO.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
@Component(value = "mus")
public class Musicien {

    @Inject
    @Named(value = "violon")
    private Instrument instrument;
    private String morceau;

    public Musicien() {
        this.morceau = "Bolero de Ravel";
    }

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

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public String getMorceau() {
        return morceau;
    }

    public void setMorceau(String morceau) {
        this.morceau = morceau;
    }

}
