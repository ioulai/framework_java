package fr.demo.jpa.app;

import fr.demo.jpa.dao.CiviliteDao;
import fr.demo.jpa.dao.DaoUtil;
import fr.demo.jpa.dao.PersonneDao;
import fr.demo.jpa.entity.CiviliteEntity;
import fr.demo.jpa.entity.PersonneEntity;
import fr.demo.jpa.exception.DALException;

/**
 * ClasseMain pour tester JPA.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class JpaApp {

    public static void main(String[] args) throws DALException {

        testerCiviliteDao();

        testerPersonneDao();

        DaoUtil.close();
    }

    /**
     * tester la couche DAO de personne.
     * 
     * @throws DALException
     */
    private static void testerPersonneDao() throws DALException {
        // purger la table personne
        PersonneDao.deleteAll();

        // READ CIVILITES
        CiviliteEntity mlle = CiviliteDao.findById("Mlle");
        CiviliteEntity mme = CiviliteDao.findById("Mme");
        CiviliteEntity m = CiviliteDao.findById("M.");
        System.out.println(mlle + "\n" + mme + "\n" + m);

        // Créer des jeux de tests
        PersonneEntity p1 = new PersonneEntity("Gaston", "Lagaffe", m);
        PersonneEntity p2 = new PersonneEntity("Edition", "Dupuis", m);
        PersonneEntity p3 = new PersonneEntity("La", "Mouette", mlle);

        PersonneDao.add(p1);
        PersonneDao.add(p2);
        PersonneDao.add(p3);

        // READ PERSONNES
        System.out.println("\\n>>> Liste des personnes après ajout");
        PersonneDao.findAll().forEach(System.out::println);

        // DELETE PERSONNE
        PersonneDao.delete(p1);

        System.out.println("\n>>> Liste des personnes après suppression");
        PersonneDao.findAll().forEach(System.out::println);

        System.out.println("\n>>> Liste des civilités après suppression");
        CiviliteDao.findAll().forEach(System.out::println);
        // les civilités ne sont pas supprimées automatiquement...

    }

    /**
     * tester la couche DAO de Civilité.
     */
    private static void testerCiviliteDao() {
        // créer des jeux de tests
        CiviliteEntity c1 = new CiviliteEntity("M.", "Monsieur");
        CiviliteEntity c2 = new CiviliteEntity("Mme", "Madame");
        CiviliteEntity c3 = new CiviliteEntity("Mlle", "Mademoiselle");

        // ajouter en bdd
        try {
            CiviliteDao.add(c1);
            CiviliteDao.add(c2);
            CiviliteDao.add(c3);
        } catch (DALException e) {
            e.printStackTrace();
        }

    }

}
