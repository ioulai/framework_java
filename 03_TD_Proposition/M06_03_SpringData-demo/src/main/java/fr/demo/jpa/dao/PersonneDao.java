package fr.demo.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.demo.jpa.entity.PersonneEntity;

public interface PersonneDao extends JpaRepository<PersonneEntity, Integer> {

	/**
	 * Recherche par nom.
	 */
	public List<PersonneEntity> findByNom(String nom);
	
	/**
	 * Recherche par nom ET par prenom.
	 */
	public List<PersonneEntity> findByNomAndPrenom(String nom, String prenom);

	/**
	 * Rechercher par nom OU prenom.
	 */
	public List<PersonneEntity> findByNomOrPrenom(String nom, String prenom);

	/**
	 * Rechercher les personnes qui n'ont PAS le nom.
	 */
	public List<PersonneEntity> findByNomNotContaining(String nom);
	
	/**
	 * Rechercher LIKE sur le NOM.
	 */
	public List<PersonneEntity> findByNomContaining(String nom);
	
	public List<PersonneEntity> findByNomStartingWithOrderByPrenom(String nom);

	public List<PersonneEntity> findByNomOrderByAdresseVilleDesc(String nom);
	
	@Query("SELECT p FROM #{#entityName} p WHERE p.nom =?1")
	public List<PersonneEntity> findHopla(String nom, String ville);
	
	
	
	
	
	
	
	
	
}
