package fr.demo.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.demo.jpa.entity.CiviliteEntity;
import fr.demo.jpa.exception.DALException;

/**
 * Classe DAO chargée des réalisers les opérations en base de données.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class CiviliteDao {

    /**
     * Chercher une civilite via l'ID.
     * 
     * @param id
     * @return
     */
    public static CiviliteEntity findById(String id) {
        return (CiviliteEntity) DaoUtil.getEntityManager().find(CiviliteEntity.class, id);
    }

    /**
     * Trouver toutes les civilites.
     * 
     * @return
     */
    public static List<CiviliteEntity> findAll() {
        String request = "SELECT p FROM civilite p";
        return DaoUtil.getEntityManager().createQuery(request, CiviliteEntity.class).getResultList();
    }

    /**
     * Créer une nouvelle entrée en base.
     * 
     * @param p
     */
    public static void add(CiviliteEntity p) throws DALException {
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
     * Supprimer une civilite (cascade).
     * 
     * @param p
     */
    public static void delete(CiviliteEntity p) throws DALException {
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
     * MAJ des informations d'une civilite.
     * 
     * @param p
     */
    public static void update(CiviliteEntity p) throws DALException {
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
