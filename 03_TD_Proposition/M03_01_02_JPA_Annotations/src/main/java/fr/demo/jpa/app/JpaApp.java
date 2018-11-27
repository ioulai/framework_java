package fr.demo.jpa.app;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.demo.jpa.entity.PersonneEntity;
import fr.demo.jpa.entity.UserEntity;

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

        // entitySimple();

        entityAvecAnnotation();
    }

    private static void entityAvecAnnotation() {
        // créer l'EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.demo.jpa.mysql.instance1");
        EntityManager em = emf.createEntityManager();

        // ### REALISER UN CREATE
        // Créer une nouvelle Entity
        PersonneEntity personneEntity = new PersonneEntity("mon nom4", "mon prenom");
        personneEntity.setDateNaissance(new GregorianCalendar(2000, 12, 9));

        // sauvegarder l'Entity dans une Transaction
        em.getTransaction().begin();
        try {
            em.persist(personneEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        // ### réaliser un READ
        try {
            String requete = "FROM PersonneEntity u";
            List<PersonneEntity> listeU = em.createQuery(requete).getResultList();

            System.out.println("liste des PersonneEntity : ");
            listeU.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer les pools de connec.
            em.close();
            emf.close();
        }
    }

    /**
     * Démonstration avec une entity simple.
     */
    private static void entitySimple() {
        // créer l'EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.demo.jpa.mysql.instance1");
        EntityManager em = emf.createEntityManager();

        // ### REALISER UN CREATE
        // Créer une nouvelle Entity
        UserEntity userEntity = new UserEntity("monLogin3", "monPass2");

        // sauvegarder l'Entity dans une Transaction
        em.getTransaction().begin();
        try {
            em.persist(userEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        // ### réaliser un READ
        try {
            String requete = "FROM UserEntity u";
            List<UserEntity> listeU = em.createQuery(requete).getResultList();

            System.out.println("liste des users : ");
            listeU.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer les pools de connec.
            em.close();
            emf.close();
        }
    }

}
