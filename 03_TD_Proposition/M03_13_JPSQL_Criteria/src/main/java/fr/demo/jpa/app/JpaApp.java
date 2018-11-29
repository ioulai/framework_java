package fr.demo.jpa.app;

import fr.demo.jpa.dao.CiviliteDao;
import fr.demo.jpa.dao.DaoUtil;
import fr.demo.jpa.dao.PersonneDao;
import fr.demo.jpa.entity.CiviliteEntity;
import fr.demo.jpa.entity.PersonneEntity;

/**
 * ClasseMain pour tester JPA.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class JpaApp {

    public static void main(String[] args) {

        // ### créer des données
        creerJeuxDeTests();

        // ### READ PERSONNES
        System.out.println("\n>>> findAll");
        PersonneDao.findAll().forEach(System.out::println);

        // ### Utiliser les criterias
        System.out.println("\n>>> findAllByNameOrder");
        PersonneDao.findAllByNameOrder().forEach(System.out::println);

        System.out.println("\n>>> findGaston");
        PersonneDao.findGaston().forEach(System.out::println);

        System.out.println("\n>>> findMlle");
        PersonneDao.findMlle().forEach(System.out::println);

        // fermer la connexion
        DaoUtil.close();
    }

    /**
     * tester la couche DAO de Civilité.
     */
    private static void creerJeuxDeTests() {
        // créer des jeux de tests
        CiviliteEntity c1 = new CiviliteEntity("M.", "Monsieur");
        CiviliteEntity c2 = new CiviliteEntity("Mme", "Madame");
        CiviliteEntity c3 = new CiviliteEntity("Mlle", "Mademoiselle");

        // ajouter en bdd
        CiviliteDao.add(c1);
        CiviliteDao.add(c2);
        CiviliteDao.add(c3);

        CiviliteEntity mlle = CiviliteDao.findById("Mlle");
        CiviliteEntity m = CiviliteDao.findById("M.");
        PersonneEntity p1 = new PersonneEntity("Gaston", "Lagaffe", m);
        PersonneEntity p2 = new PersonneEntity("Edition", "Dupuis", m);
        PersonneEntity p3 = new PersonneEntity("La", "Mouette", mlle);

        // ### Persist en bdd
        PersonneDao.add(p1);
        PersonneDao.add(p2);
        PersonneDao.add(p3);
    }
}
