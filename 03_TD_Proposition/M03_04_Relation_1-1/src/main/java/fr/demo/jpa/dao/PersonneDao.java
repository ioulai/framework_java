package fr.demo.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
     * Chercher une personne via l'ID.
     * 
     * @param id
     * @return
     */
    public PersonneEntity findById(Integer id) {
        return (PersonneEntity) DaoUtil.getEntityManager().find(PersonneEntity.class, id);
    }

    /**
     * Trouver toutes les personnes.
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PersonneEntity> findAll() {
        String request = "SELECT p FROM Personne p";
        return (List<PersonneEntity>) DaoUtil.getEntityManager().createQuery(request).getResultList();
    }

    /**
     * Créer une nouvelle entrée en base.
     * 
     * @param p
     */
    public void add(PersonneEntity p) throws Exception {
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(p);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }

    /**
     * Supprimer une personne.
     * 
     * @param p
     */
    public void delete(PersonneEntity p) throws Exception {
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(p);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }

    /**
     * MAJ des informations d'une personne.
     * 
     * @param p
     */
    public void update(PersonneEntity p) throws Exception {
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(p);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }
}
