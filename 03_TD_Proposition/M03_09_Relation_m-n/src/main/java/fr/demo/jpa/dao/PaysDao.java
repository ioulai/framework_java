package fr.demo.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.demo.jpa.entity.PaysEntity;
import fr.demo.jpa.exception.DALException;

/**
 * Classe DAO chargée des réalisers les opérations en base de données.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class PaysDao {

    /**
     * Chercher une pays via l'ID.
     * 
     * @param id
     * @return
     */
    public static PaysEntity findById(String id) {
        return (PaysEntity) DaoUtil.getEntityManager().find(PaysEntity.class, id);
    }

    /**
     * Trouver toutes les payss.
     * 
     * @return
     */
    public static List<PaysEntity> findAll() {
        String request = "SELECT p FROM Pays p";
        return DaoUtil.getEntityManager().createQuery(request, PaysEntity.class).getResultList();
    }

    /**
     * Créer une nouvelle entrée en base.
     * 
     * @param p
     */
    public static void add(PaysEntity p) throws DALException {
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
     * Supprimer une pays (cascade).
     * 
     * @param p
     */
    public static void delete(PaysEntity p) throws DALException {
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
     * MAJ des informations d'une pays.
     * 
     * @param p
     */
    public static void update(PaysEntity p) throws DALException {
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
