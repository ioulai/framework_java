package fr.demo.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
     * DynamicQuery : Trouver toutes les personnes.
     * 
     * @return
     */
    public static List<PersonneEntity> findAll() {
        String request = "SELECT p FROM Personne p";
        return DaoUtil.getEntityManager().createQuery(request, PersonneEntity.class).getResultList();
    }

    /**
     * DynamicQuery : utiliser Query
     * 
     * @return
     */
    public static List<PersonneEntity> findGastonWithQuery() {
        EntityManager em = DaoUtil.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Personne p WHERE p.nom = 'Gaston'");
        // Warning = Query n'est pas typé
        return query.getResultList();
    }

    /**
     * DynamicQuery : utiliser TypedQuery.
     * 
     * @return
     */
    public static List<PersonneEntity> findGastonWithTypedQuery() {
        EntityManager em = DaoUtil.getEntityManager();
        TypedQuery<PersonneEntity> query = em.createQuery("SELECT p FROM Personne p WHERE p.nom = 'Gaston'", PersonneEntity.class);
        return query.getResultList();
    }

    /**
     * DynamicQuery : Utiliser les paramètres nommés.
     * 
     * @return
     */
    public static List<PersonneEntity> findGastonWithParameter(String nom) {
        EntityManager em = DaoUtil.getEntityManager();
        TypedQuery<PersonneEntity> query = em.createQuery("SELECT p FROM Personne p WHERE p.nom = :nom", PersonneEntity.class);
        query.setParameter("nom", nom);
        return query.getResultList();
    }

    /**
     * DynamicQuery : Utiliser les paramètres selon leurs positions.
     * 
     * @return
     */
    public static List<PersonneEntity> findGastonWithParameterWithPosition(String nom) {
        EntityManager em = DaoUtil.getEntityManager();
        TypedQuery<PersonneEntity> query = em.createQuery("SELECT p FROM Personne p WHERE p.nom = ?1", PersonneEntity.class);
        query.setParameter(1, nom);
        return query.getResultList();
    }

    /**
     * DynamicQuery : Trouver un résultat.
     * 
     * @return
     */
    public static PersonneEntity findOneGaston() {
        EntityManager em = DaoUtil.getEntityManager();
        TypedQuery<PersonneEntity> query = em.createQuery("SELECT p FROM Personne p WHERE p.nom = 'Gaston'", PersonneEntity.class);

        PersonneEntity result = null;
        try {
            result = query.getSingleResult();
        } catch (Exception e) {
            // do not nothing if result = 0
        }
        return result;
    }

    /**
     * DynamicQuery : Compter le nombre de résultats.
     * 
     * @return
     */
    public static Long countPersonne() {
        EntityManager em = DaoUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(p.id) FROM Personne p", Long.class);
        return query.getSingleResult();
    }

    /**
     * DynamicQuery : Extraire les enregistrements d'un attribut.
     * 
     * @return
     */
    public static List<String> extractOneAttribut() {
        EntityManager em = DaoUtil.getEntityManager();
        TypedQuery<String> query = em.createQuery("SELECT p.nom FROM Personne p", String.class);
        return query.getResultList();
    }

    /**
     * DynamicQuery : Faire une jointure.
     * 
     * @return
     */
    public static List<PersonneEntity> jointTables() {
        EntityManager em = DaoUtil.getEntityManager();
        TypedQuery<PersonneEntity> query = em.createQuery("SELECT p FROM Personne p JOIN p.civilite c WHERE c.cle = 'Mlle' ORDER BY c.libelle", PersonneEntity.class);
        return query.getResultList();
    }

    /**
     * DynamicQuery : Supprimer.
     * 
     * @return
     */
    public static void removeDupuis() {
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        Query query = em.createQuery("DELETE FROM Personne p WHERE p.prenom = 'Dupuis'");
        
        et.begin();
        try {
            query.executeUpdate();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }

    /**
     * DynamicQuery : Modifier.
     * 
     * @return
     */
    public static void udpateGaston() {
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        Query query = em.createQuery("UPDATE Personne p SET p.prenom = 'LaaaaGaffe' WHERE p.nom = 'Gaston'");
        
        et.begin();
        try {
            query.executeUpdate();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
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
