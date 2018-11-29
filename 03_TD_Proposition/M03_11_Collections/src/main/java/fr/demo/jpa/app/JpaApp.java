package fr.demo.jpa.app;

import java.util.ArrayList;
import java.util.List;

import fr.demo.jpa.dao.DaoUtil;
import fr.demo.jpa.dao.PersonneDao;
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

        // Créer des jeux de tests
        List<String> listeSport = new ArrayList<>();
        listeSport.add("Athletisme");
        listeSport.add("Judo");
        listeSport.add("Badminton");
        List<String> listeSport2 = new ArrayList<>();
        listeSport2.add("Voile");
        listeSport2.add("Pêche");
        listeSport2.add("Chasse");

        PersonneEntity p1 = new PersonneEntity("Jean", "Paul", listeSport);
        PersonneEntity p2 = new PersonneEntity("Marie", "Rosée", listeSport2);

        // persist on database
        PersonneDao.add(p1);
        PersonneDao.add(p2);

        System.out.println("\n>>> Enregistrements après ajout :");
        PersonneDao.findAll().forEach(System.out::println);

        // delete personne on database
        PersonneDao.delete(p1);

        System.out.println("\n>>> Enregistrements après suppression :");
        PersonneDao.findAll().forEach(System.out::println);

        // fermer la connexion
        DaoUtil.close();
    }

}
