package fr.demo.spring.jdbc.dao;

import java.util.List;

import fr.demo.spring.jdbc.bean.Personne;

/**
 * Interface DAO.
 * @author Gaël Sigogneau
 * @since 23 nov. 2018
 *
 */
public interface PersonneDao {

    /**
     * Ajouter une personne.
     * 
     * @param p
     */
    public void addPersonne(Personne p);

    /**
     * Supprimer une personne.
     * 
     * @param p
     */
    public void deletePersonne(Personne p);

    /**
     * MAJ d'une personne.
     * 
     * @param p
     */
    public void updatePersonne(Personne p);

    /**
     * Chercher une personne par l'ID.
     * 
     * @param id
     * @return
     */
    public Personne getPersonne(int id);

    /**
     * Récupérer toute la bdd.
     * 
     * @return
     */
    public List<Personne> getPersonnes();
}
