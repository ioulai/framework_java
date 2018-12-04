package fr.demo.spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import fr.demo.spring.orm.bean.Personne;

/**
 * Déclarer cette classe comme un Repository SPRING. Permet l'injection de DAOs.
 * 
 * @author Gaël Sigogneau
 * @since 23 nov. 2018
 *
 */
@Repository
public class PersonneDaoImpl implements PersonneDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Personne> findAll() {
        return em.createQuery("SELECT p FROM Personne p", Personne.class).getResultList();
    }

    @Override
    public Personne findById(int id) {
        return em.find(Personne.class, id);
    }

    @Override
    @Transactional // nécessaire pour une modification en base
    public void add(Personne personne) {
        em.persist(personne);
    }

    @Override
    @Transactional // nécessaire pour une modification en base
    public void update(Personne personne) {
        em.merge(personne);
    }

    @Override
    @Transactional // nécessaire pour une modification en base
    public void delete(int id) {
        Personne personne = findById(id);
        em.remove(personne);
    }

    @Override
    @Transactional // nécessaire pour une modification en base
    public void delete(String nom) {
        em.createQuery("DELETE FROM personne WHERE nom = :nom").setParameter("nom", nom).executeUpdate();
    }

    @Override
    @Transactional // nécessaire pour une modification en base
    public void delete(Personne personne) {
        delete(personne.getId());
    }

    @Override
    @Transactional // nécessaire pour une modification en base
    public Personne findLast() {
        return findById(em.createQuery("SELECT MAX(id) FROM personne", Integer.class).getSingleResult());
    }
}
