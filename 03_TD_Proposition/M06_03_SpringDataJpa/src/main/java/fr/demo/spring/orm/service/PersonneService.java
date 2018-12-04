package fr.demo.spring.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.demo.spring.orm.bean.Personne;
import fr.demo.spring.orm.dao.PersonneDao;

/**
 * Classe de service.
 * 
 * @author Gaël Sigogneau
 * @since 23 nov. 2018
 *
 */
@Service
public class PersonneService {

    @Autowired
    private PersonneDao personneDao;

    public List<Personne> listePersonne() {
        // oui la méthode findAll existe déjà dans SpringDataJpa
        return personneDao.findAll();
    }

    public Personne recherchePersonne(int id) {
        return personneDao.findOne(id);
    }

    public void ajouterPersonne(Personne p) {
        personneDao.save(p);
    }

    public void modifierPersonne(Personne p) {
        personneDao.save(p);
    }

    public void supprimerPersonne(Personne p) {
        personneDao.delete(p);
    }

    public void supprimerPersonne(int id) {
        personneDao.delete(id);
    }

    public long nombreDelement() {
        return personneDao.count();
    }

    public List<Personne> rechercherPersonne(String nom) {
        return personneDao.findByNom(nom);
    }

    public List<Personne> rechercherPersonneNomContenant(String nom) {
        return personneDao.findByNomContaining(nom);
    }

    public List<Personne> rechercherPersonneNomNeContenantPas(String nom) {
        return personneDao.findByNomNotContaining(nom);
    }

    public List<Personne> rechercherPersonneNomCommencantOrdonneParAdresse(String nom) {
        // jointure automatique..
        return personneDao.findByNomStartingWithOrderByAdresseVilleAscAdresseCodePostalDesc(nom);
    }

    public List<Personne> rechercherPersonneParVille(String ville) {
        // jointure automatique..
        return personneDao.findByAdresseVille(ville);
    }
}
