package fr.demo.couplage.business;

import java.util.ArrayList;
import java.util.List;

import fr.demo.couplage.musicien.bo.Pianiste;
import fr.demo.couplage.musicien.bo.Violoniste;

/**
 * Business Object : BO.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
public class Orchestre {

    private List<Object> listeMusiciens;

    public Orchestre() {
        super();
        this.listeMusiciens = new ArrayList<>();
    }

    public void add(Object musicien) {
        listeMusiciens.add(musicien);
    }

    public void jouer() {
        for (Object obj : listeMusiciens) {
            if (obj instanceof Pianiste) {
                ((Pianiste) obj).jouerMorceau();
            }
            if (obj instanceof Violoniste) {
                ((Violoniste) obj).jouerMorceau();
            }
        }
    }
}
