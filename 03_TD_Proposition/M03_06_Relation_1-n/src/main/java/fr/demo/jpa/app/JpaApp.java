package fr.demo.jpa.app;

import java.util.ArrayList;
import java.util.List;

import fr.demo.jpa.dao.DaoUtil;
import fr.demo.jpa.dao.PersonneDao;
import fr.demo.jpa.entity.AdresseEntity;
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
        // création de jeux de tests
        List<AdresseEntity> listeAdresses1 = new ArrayList<>();
        List<AdresseEntity> listeAdresses2 = new ArrayList<>();
        AdresseEntity addr1 = new AdresseEntity("44000", "Nantes");
        listeAdresses1.add(addr1);
        listeAdresses1.add(new AdresseEntity("44100", "Nantes"));
        listeAdresses2.add(new AdresseEntity("44200", "Nantes"));
        listeAdresses2.add(new AdresseEntity("44300", "Nantes"));

        PersonneEntity p1 = new PersonneEntity("jean", "paul", listeAdresses1);
        PersonneEntity p2 = new PersonneEntity("Marie", "Dupont", listeAdresses2);

        // ### ajouter des enregistrements en BDD
        PersonneDao.add(p1);
        PersonneDao.add(p2);

        System.out.println("\n>>> Enregistrements en base :");
        PersonneDao.findAll().forEach(System.out::println);

        // ### Modifier des entrées
        // modifier une adresse
        addr1.setCodePostal("56000");
        // ajouter une adresse
        listeAdresses1.add(new AdresseEntity("72000", "paris"));
        PersonneDao.update(p1);

        System.out.println("\n>>> Enregistrements après modification");
        PersonneDao.findAll().forEach(System.out::println);

        // ### Supprimer une adresse d'une personne (enfant)
        p1.getAdresse().remove(addr1);
        PersonneDao.update(p1);

        System.out.println("\n>>> Enregistrements après suppression");
        PersonneDao.findAll().forEach(System.out::println);

        // Fermer la connexion
        DaoUtil.close();
    }

}
