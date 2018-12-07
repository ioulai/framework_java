package fr.demo.jpa.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.demo.jpa.entity.PersonneEntity;
import fr.demo.jpa.service.PersonneService;

/**
 * ClasseMain pour tester JPA.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class JpaApp {

	public static void main(String[] args) {
		// Ceci est une classe "API/IHM" : Pas d'instance de DAO ici = dev. en couche!!!

		// PRE-REQUIS : ContextSpring dans une JAVA-SE
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		// 2- Récupérer la DataSource
		PersonneService service = context.getBean("personneService", PersonneService.class);

		// 1) Ajouter des Personnes
		PersonneEntity p2 = new PersonneEntity("un nom 2", "un prenom 2");
		service.add(new PersonneEntity("un nom 1", "un prenom 1"));
		service.add(p2);

		// 2) Lister (console)
		service.findAll().forEach(System.out::println);

		// 3) Modifier une Personne
		p2.setNom("nom2:JPA-SPRING ORM");
		service.update(p2);

		// 4) Lister (console)
		service.findAll().forEach(System.out::println);

		// 5) Supprimer une Personne
		service.delete(p2);

		// 6) Lister (console)
		service.findAll().forEach(System.out::println);

		// 99) Fermer le context
		((ClassPathXmlApplicationContext) context).close();
	}

}
