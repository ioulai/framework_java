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
        return personneDao.findAll();
    }

    public Personne recherchePersonne(int id) {
        return personneDao.findById(id);
    }

    public Personne rechercherDernier() {
        return personneDao.findLast();
    }

    public void ajouterPersonne(Personne p) {
        personneDao.add(p);
    }

    public void modifierPersonne(Personne p) {
        personneDao.update(p);
    }

    public void supprimerPersonne(Personne p) {
        personneDao.delete(p.getId());
    }

    public void supprimerPersonne(String nom) {
        personneDao.delete(nom);
    }

    public void supprimerPersonne(int id) {
        personneDao.delete(id);
    }
}
