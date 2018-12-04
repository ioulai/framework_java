package fr.demo.spring.orm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.demo.spring.orm.bean.Personne;

/**
 * Interface DAO.
 * 
 * @author Gaël Sigogneau
 * @since 23 nov. 2018
 *
 */
public interface PersonneDao extends JpaRepository<Personne, Integer> {

    public List<Personne> findByNom(String nom);

    public List<Personne> findByNomContaining(String nom);

    public List<Personne> findByNomNotContaining(String nom);

    public List<Personne> findByNomOrPrenom(String nom, String prenom);

    public List<Personne> findByNomAndPrenom(String nom, String prenom);

    public List<Personne> findByNomStartingWithOrderByAdresseVilleAscAdresseCodePostalDesc(String nom);

    public List<Personne> findByAdresseVille(String ville);

    // public List<Personne> findAll();
    // public Personne findById(int id);
    // public void add(Personne personne);
    // public void update(Personne personne);
    // public void delete(int id);
    // public void delete(String nom);
    // public void delete(Personne personne);
    // public Personne findLast();
}
