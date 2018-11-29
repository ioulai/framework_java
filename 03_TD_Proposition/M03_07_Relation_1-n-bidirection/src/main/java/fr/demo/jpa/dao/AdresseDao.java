package fr.demo.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.demo.jpa.entity.AdresseEntity;
import fr.demo.jpa.exception.DALException;

/**
 * Classe DAO chargée des réalisers les opérations en base de données.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class AdresseDao {

    /**
     * Chercher une adresse via l'ID.
     * 
     * @param id
     * @return
     */
    public static AdresseEntity findById(Integer id) {
        return (AdresseEntity) DaoUtil.getEntityManager().find(AdresseEntity.class, id);
    }

    /**
     * Trouver toutes les adresses.
     * 
     * @return
     */
    public static List<AdresseEntity> findAll() {
        String request = "SELECT p FROM Adresse p";
        return DaoUtil.getEntityManager().createQuery(request, AdresseEntity.class).getResultList();
    }

    /**
     * Créer une nouvelle entrée en base.
     * 
     * @param p
     */
    public static void add(AdresseEntity p) throws DALException {
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(p);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DALException("Erreur lors de l'écriture : " + e.getMessage());
        }
    }

    /**
     * Supprimer une adresse (cascade).
     * 
     * @param p
     */
    public static void delete(AdresseEntity p) throws DALException {
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(p);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DALException("Erreur lors de la suppression : " + e.getMessage());
        }
    }

    /**
     * MAJ des informations d'une adresse.
     * 
     * @param p
     */
    public static void update(AdresseEntity p) throws DALException {
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(p);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DALException("Erreur lors de la maj : " + e.getMessage());
        }
    }
}
