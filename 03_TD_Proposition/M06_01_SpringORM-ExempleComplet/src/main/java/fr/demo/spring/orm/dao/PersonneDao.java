package fr.demo.spring.orm.dao;

import java.util.List;

import fr.demo.spring.orm.bean.Personne;

/**
 * Interface DAO.
 * 
 * @author Gaël Sigogneau
 * @since 23 nov. 2018
 *
 */
public interface PersonneDao {

    public List<Personne> findAll();

    public Personne findById(int id);

    public void add(Personne personne);

    public void update(Personne personne);

    public void delete(int id);

    public void delete(String nom);

    public void delete(Personne personne);
    
    public Personne findLast();
}
