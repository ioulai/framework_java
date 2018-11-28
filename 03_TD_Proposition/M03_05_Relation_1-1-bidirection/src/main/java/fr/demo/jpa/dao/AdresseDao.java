package fr.demo.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.demo.jpa.entity.AdresseEntity;

/**
 * Classe DAO chargée des réalisers les opérations en base de données.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class AdresseDao {

    /**
     * trouver une adresse.
     * 
     * @param id
     * @return
     */
    public AdresseEntity findById(Integer id) {
        return (AdresseEntity) DaoUtil.getEntityManager().find(AdresseEntity.class, id);
    }

    /**
     * Rechercher toutes les adresses avec une request SQL native.
     * 
     * @return
     */
    public List<AdresseEntity> findAll() {
        String request = "SELECT Object(a) FROM Adresse a";
        return DaoUtil.getEntityManager().createQuery(request, AdresseEntity.class).getResultList();
    }

    /**
     * Créer ou mettre à jour une adresse.
     * 
     * @param adresse
     */
    public void addOrUpdate(AdresseEntity adresse) {
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            if (adresse.getId() == null) {
                em.persist(adresse);
            } else {
                em.merge(adresse);
            }
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }

    /**
     * supprimer une adresse (cascade).
     * 
     * @param adresse
     * @throws Exception
     */
    public void delete(AdresseEntity adresse) throws Exception {
        EntityManager em = DaoUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(adresse);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }
}
