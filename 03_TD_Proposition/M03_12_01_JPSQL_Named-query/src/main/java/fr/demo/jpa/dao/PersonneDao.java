package fr.demo.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
     * NamedQuery : findTous = simple request.
     * 
     * @return
     */
    public static List<PersonneEntity> findTous() {
        return DaoUtil.getEntityManager().createNamedQuery("findTous", PersonneEntity.class).getResultList();
    }

    /**
     * NamedQuery : findLikeName = request with parameter.
     * 
     * @param name
     * @return
     */
    public static List<PersonneEntity> findLikeName(String name) {
        TypedQuery<PersonneEntity> result = DaoUtil.getEntityManager().createNamedQuery("findLikeName", PersonneEntity.class);
        result.setParameter("var", "%" + name + "%");
        return result.getResultList();
    }

    /**
     * NamedQuery : findMister = request with tables associations
     * 
     * @return
     */
    public static List<PersonneEntity> findMister() {
        return DaoUtil.getEntityManager().createNamedQuery("findMisters", PersonneEntity.class).getResultList();
    }

    /**
     * Trouver toutes les personnes.
     * 
     * @return
     */
    public static List<PersonneEntity> findAll() {
        String request = "SELECT p FROM Personne p";
        return DaoUtil.getEntityManager().createQuery(request, PersonneEntity.class).getResultList();
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
