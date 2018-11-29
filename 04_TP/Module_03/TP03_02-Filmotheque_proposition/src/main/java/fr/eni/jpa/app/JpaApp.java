package fr.eni.jpa.app;

import java.util.ArrayList;
import java.util.List;

import fr.eni.jpa.bean.Acteur;
import fr.eni.jpa.bean.Film;
import fr.eni.jpa.bean.Realisateur;
import fr.eni.jpa.bean.Style;
import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.dao.GenericDao;
import fr.eni.jpa.dao.GenericDaoImpl;

public class JpaApp {

    public static void main(String[] args) throws Exception {
        
        // ### Creer les jeux de tests
        Style s1 = new Style("Science fiction");
        Realisateur r1 = new Realisateur("Gaston", "Lagaffe");

        List<Acteur> acteurs = new ArrayList<>();
        acteurs.add(new Acteur("jean", "Dujardin"));
        acteurs.add(new Acteur("Marie", "Rose"));
        acteurs.add(new Acteur("Paul", "Gordon"));

        String synopsis = "Le faux-texte est, en imprimerie, un texte sans signification";
        
        Film f1 = new Film("mon premier film", 2018, s1, r1, "1h30", acteurs, false, synopsis);

        // ### enregistrer le/les styles de films
        GenericDao<Style, Integer> daoStyle = new GenericDaoImpl<>();
        daoStyle.add(s1);
        
        // ### enregistrer le/les films
        GenericDao<Film, Integer> daoFilm = new GenericDaoImpl<>();
        daoFilm.add(f1);
        
        // ### rechercher les films
        daoFilm.findAll(Film.class).forEach(System.out::println);
        
        // ### fermer la connexion
        DAOUtil.close();
    }

}
