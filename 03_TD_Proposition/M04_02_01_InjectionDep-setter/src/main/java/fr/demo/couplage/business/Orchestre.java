package fr.demo.couplage.business;

import java.util.ArrayList;
import java.util.List;

import fr.demo.couplage.musicien.bo.Musicien;

/**
 * Business Object : BO.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
public class Orchestre {

    private List<Musicien> listeMusiciens;

    public Orchestre() {
        super();
        this.listeMusiciens = new ArrayList<>();
    }

    public void add(Musicien musicien) {
        listeMusiciens.add(musicien);
    }

    public void jouer() {
        for (Musicien obj : listeMusiciens) {
            obj.jouerMorceau();
        }
    }
}
