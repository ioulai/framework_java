package fr.demo.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.demo.jpa.dao.DaoUtil;
import fr.demo.jpa.entity.BerlineEntity;
import fr.demo.jpa.entity.VoitureDeCourseEntity;
import fr.demo.jpa.entity.VoitureEntity;

/**
 * ClasseMain pour tester JPA.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class JpaApp {

    public static void main(String[] args) {

        // créer des jeux de test
        VoitureEntity v1 = new VoitureEntity("Renault clio");
        BerlineEntity b1 = new BerlineEntity("BMW", "Blanc");
        VoitureDeCourseEntity c1 = new VoitureDeCourseEntity("Ferrari", "Ferrari écurie");

        // call du manager
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        // persistence en bdd
        et.begin();
        try {
            em.persist(v1);
            em.persist(b1);
            em.persist(c1);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }

        System.out.println("\n>>> Afficher toutes les voitures");
        em.createQuery("SELECT v FROM voiture v", VoitureEntity.class).getResultList().forEach(System.out::println);

        System.out.println("\n>>> Afficher toutes les berlines");
        em.createQuery("SELECT v FROM berline v", VoitureEntity.class).getResultList().forEach(System.out::println);

        System.out.println("\n>>> Afficher toutes les voitures de course");
        em.createQuery("SELECT v FROM course v", VoitureEntity.class).getResultList().forEach(System.out::println);

        // @formatter:off
        System.out.println("\n>>> Afficher toutes les berlines avec une clause WHERE en PSQL");
        em.createQuery("SELECT v FROM voiture v WHERE discr = :var", VoitureEntity.class)
            .setParameter("var", "B")
            .getResultList()
            .forEach(System.out::println);
        // @formatter:on

        DaoUtil.close();
    }

}
