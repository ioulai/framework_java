package fr.demo.jpa.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import com.nimbusds.openid.connect.sdk.claims.Address;

import fr.demo.jpa.dao.AdresseDao;
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

        // ### Ajout d'une nouvelle adresse par AdresseDAO (utilisation de la bidirection
        AdresseEntity addr2 = new AdresseEntity("1111", "hopla");
        addr2.setPersonne(new PersonneEntity("az", "ze"));
        AdresseDao.add(addr2);
        
        System.out.println("\n>>> Enregistrements en base après l'insertion :");
        PersonneDao.findAll().forEach(System.out::println);
        
        // ### Supprimer un enregistrement
        // La personne est supprimée avec l'adresse si CascadeType.ALL
        AdresseDao.delete(addr2);

        System.out.println("\n>>> Enregistrements en base après la suppression:");
        PersonneDao.findAll().forEach(System.out::println);
        
        // Fermer la connexion
        DaoUtil.close();
    }

}
