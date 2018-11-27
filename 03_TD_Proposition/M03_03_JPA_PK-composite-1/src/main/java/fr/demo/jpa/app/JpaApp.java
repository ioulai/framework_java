package fr.demo.jpa.app;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.demo.jpa.entity.PersonneEntity;
import fr.demo.jpa.entity.PersonnePk;

/**
 * ClasseMain pour tester JPA.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
@SuppressWarnings("unchecked")
public class JpaApp {

    public static void main(String[] args) {

        // créer l'EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.demo.jpa.mysql.instance1");
        EntityManager em = emf.createEntityManager();

        // ### REALISER UN CREATE
        // Créer une nouvelle Entity
        PersonneEntity p1 = new PersonneEntity("mon nom 1", "mon prenom");
        p1.setDateNaissance(new GregorianCalendar(2000, 12, 9));
        PersonneEntity p2 = new PersonneEntity("mon nom 2", "mon prenom");

        // sauvegarder l'Entity dans une Transaction
        em.getTransaction().begin();
        try {
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        // ### réaliser un READ
        try {
            String requete = "FROM PersonneE u";
            List<PersonneEntity> listeU = em.createQuery(requete).getResultList();
            System.out.println("liste des PersonneEntity : ");
            listeU.forEach(perso -> {
                System.out.println(perso);
            });

            System.out.println("réaliser une recherche sur une clé PK composée :");
            PersonnePk pk = new PersonnePk("mon nom 1", "mon prenom");
            PersonneEntity personne = em.find(PersonneEntity.class, pk);
            System.out.println(personne);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer les pools de connec.
            em.close();
            emf.close();
        }

    }

}
