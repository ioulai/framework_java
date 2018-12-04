package fr.demo.spring.orm.app;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.demo.spring.orm.bean.Adresse;
import fr.demo.spring.orm.bean.Personne;
import fr.demo.spring.orm.service.PersonneService;

/**
 * Demonstration de code avec SpringORM
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
public class SpringOrmApp {

    /**
     * MainEntry.
     * 
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {

        // ### ouvrir le contexte spring ~= container
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        // Instance de PersonneService
        PersonneService service = context.getBean("personneService", PersonneService.class);

        System.out.println("\n>>> listePersonne");
        service.listePersonne().forEach(System.out::println);

        System.out.println("\n>>> ajouterPersonne");
        Personne p1 = new Personne("Gaston", "Lagaffe", 10, new Adresse("44000", "nantes"));

        service.ajouterPersonne(p1);
        service.ajouterPersonne(new Personne("Jean", "Dupuis", 55, new Adresse("44100", "Nantes")));
        service.ajouterPersonne(new Personne("Marie", "Dupuis", 55, new Adresse("44300", "Paris")));
        service.ajouterPersonne(new Personne("Marie", "Dupuis", 55, new Adresse("44200", "vannes")));
        service.listePersonne().forEach(System.out::println);

        System.out.println("\n>>> modifierPersonne");
        p1.setAge(28);
        service.modifierPersonne(p1);
        service.listePersonne().forEach(System.out::println);

        System.out.println("\n>>> supprimerPersonne");
        service.supprimerPersonne(p1);
        service.listePersonne().forEach(System.out::println);

        System.out.println("\n>>> count" + service.nombreDelement());

        System.out.println("\n>>> rechercherPersonneNomContenant");
        service.rechercherPersonneNomContenant("an").forEach(System.out::println);

        System.out.println("\n>>> rechercherPersonneNomNeContenantPas");
        service.rechercherPersonneNomNeContenantPas("an").forEach(System.out::println);

        System.out.println("\n>>> rechercherPersonneNomCommencantOrdonneParAdresse");
        service.rechercherPersonneNomCommencantOrdonneParAdresse("").forEach(System.out::println);

        System.out.println("\n>>> rechercherPersonneNomCommencantOrdonneParAdresse");
        service.rechercherPersonneParVille("Nantes").forEach(System.out::println);

        // ### fermer la conn
        context.close();
    }

}
