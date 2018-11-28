package fr.demo.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe Utile : Possible dans ce TP car application lourde = pas d'accès multiple à la BDD.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class DaoUtil {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("fr.demo.jpa.mysql.instance1");
        em = emf.createEntityManager();
    }

    /**
     * Get JDBC EntityManager.
     * 
     * @return
     */
    public static EntityManager getEntityManager() {
        return em;
    }

    /**
     * Close connection.
     */
    public static void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

}
