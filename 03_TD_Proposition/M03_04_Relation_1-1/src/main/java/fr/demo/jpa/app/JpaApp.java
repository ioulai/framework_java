package fr.demo.jpa.app;

import fr.demo.jpa.dao.DaoUtil;
import fr.demo.jpa.dao.PersonneDao;
import fr.demo.jpa.entity.AdresseEntity;
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
        // création de jeux de tests
        AdresseEntity a1 = new AdresseEntity("44000", "Nantes");
        AdresseEntity a2 = new AdresseEntity("56130", "LRB");

        PersonneEntity p1 = new PersonneEntity("jean", "paul", a1);
        PersonneEntity p2 = new PersonneEntity("Marie", "Dupont", a2);

        // call de la couche DAO
        PersonneDao dao = new PersonneDao();

        // ### ajouter une personne à la BDD
        try {
            dao.add(p1);
            dao.add(p2);
        } catch (Exception e) {
            System.err.println("Impossible d'ajouter à la BBD");
            e.printStackTrace();
        }

        // ### MAJ de la BDD
        p1.getAdresse().setCodePostal("44100");
        try {
            dao.update(p1);
        } catch (Exception e) {
            System.err.println("Impossible de mettre à jour la BBD");
            e.printStackTrace();
        }

        // ### Lecture des enregistrements
        dao.findAll().forEach(System.out::println);

        // ### Supprimer un enregistrement
        try {
            dao.delete(p2);
        } catch (Exception e) {
            System.err.println("Impossible de supprimer un enregistrement de la BBD");
            e.printStackTrace();
        }
        
        // Fermer la connexion
        DaoUtil.close();
    }

}
