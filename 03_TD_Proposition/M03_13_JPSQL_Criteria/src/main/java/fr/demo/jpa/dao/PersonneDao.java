package fr.demo.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.demo.jpa.entity.CiviliteEntity;
import fr.demo.jpa.entity.PersonneEntity;

/**
 * Classe DAO chargée des réalisers les opérations en base de données.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class PersonneDao {

    /**
     * Criteria : Faire une requête SELECT simple.
     * 
     * @return
     */
    public static List<PersonneEntity> findAll() {
        // get entitymanager
        EntityManager em = DaoUtil.getEntityManager();
        // créer un Criteria builder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // Créer l'obj Query
        CriteriaQuery<PersonneEntity> query = cb.createQuery(PersonneEntity.class);
        // Construire la requête : FROM Personne.
        Root<PersonneEntity> liste = query.from(PersonneEntity.class);
        // SELECT * FROM Personne
        query.select(liste);
        // Construire la requête préparée
        TypedQuery<PersonneEntity> typedQuery = em.createQuery(query);
        // exec de la requête
        return typedQuery.getResultList();
    }

    /**
     * Criteria : Réaliser un tri.
     * 
     * @return
     */
    public static List<PersonneEntity> findAllByNameOrder() {
        // instances des objs necessaire au criteria
        EntityManager em = DaoUtil.getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<PersonneEntity> query = builder.createQuery(PersonneEntity.class);

        // definition de la reuqête
        Root<PersonneEntity> personne = query.from(PersonneEntity.class);
        Order order = builder.asc(personne.get("nom"));

        // construction de la requête
        query.select(personne);
        query.orderBy(order);

        // envoi de la requête
        TypedQuery<PersonneEntity> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

    /**
     * Criteria : Réaliser une clause WHERE
     * 
     * @return
     */
    public static List<PersonneEntity> findGaston() {
        // instances des objs necessaire au criteria
        EntityManager em = DaoUtil.getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<PersonneEntity> query = builder.createQuery(PersonneEntity.class);

        // definition de la reuqête
        Root<PersonneEntity> personne = query.from(PersonneEntity.class);
        Predicate predicate = builder.equal(personne.get("nom"), "Gaston");

        // construction de la requête
        query.select(personne);
        query.where(predicate);

        // envoi de la requête
        TypedQuery<PersonneEntity> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

    /**
     * Criteria : réaliser une jointure JOIN.
     * 
     * @return
     */
    public static List<PersonneEntity> findMlle() {
        // instances des objs necessaire au criteria
        EntityManager em = DaoUtil.getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<PersonneEntity> query = builder.createQuery(PersonneEntity.class);

        // definition de la reuqête
        Root<PersonneEntity> personne = query.from(PersonneEntity.class);
        Join<PersonneEntity, CiviliteEntity> join = personne.join("civilite");
        Predicate whereClause = builder.equal(join.get("cle"), "Mlle");

        // construction de la requête
        query.select(personne);
        query.where(whereClause);

        // envoi de la requête
        TypedQuery<PersonneEntity> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

    /**
     * Créer une nouvelle entrée en base.
     * 
     * @param p
     */
    public static void add(PersonneEntity p) {
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(p);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }
}
