package fr.demo.couplage.musicien.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired(required = false)
    @Qualifier("piano")
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
