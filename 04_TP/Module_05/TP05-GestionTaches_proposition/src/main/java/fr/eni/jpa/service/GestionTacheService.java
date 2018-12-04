package fr.eni.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.jpa.bean.Tache;
import fr.eni.jpa.dao.TacheDAO;

/**
 * Service de gestion des tâches.
 * 
 * @author Gaël Sigogneau
 * @since 23 nov. 2018
 *
 */
@Service
public class GestionTacheService {

    @Autowired
    private TacheDAO dao;

    /**
     * Lister toutes les tâches.
     * 
     * @return
     */
    public List<Tache> listeAllTaches() {
        return dao.findAll();
    }

    /**
     * trouver une tâche.
     * 
     * @param id
     * @return
     */
    public Tache trouverUneTache(int id) {
        return dao.findById(id);
    }

    /**
     * Ajouter une tâche.
     * 
     * @param s
     * @throws Exception
     */
    public void ajoutUneTache(Tache s) throws Exception {
        if (s.getLibelle() != null && !s.getLibelle().trim().equals("")) {
            dao.ajoutStyle(s);
        } else {
            throw new Exception("...");
        }
    }

    /**
     * Modifier une tâche.
     * 
     * @param s
     * @throws Exception
     */
    public void modifierUneTache(Tache s) throws Exception {
        dao.update(s);
    }

    /**
     * Supprimer une tâche par l'id.
     * 
     * @param id
     * @throws Exception
     */
    public void supprimerUneTache(int id) throws Exception {
        Tache s = dao.findById(id);
        dao.delete(s);
    }

    // public void supprimerUneTache(Tache s) throws Exception {
    // dao.delete(s);
    // }

    // public List<Tache> trier(String type) {
    // List<Tache> liste = null;
    // switch (type) {
    // default:
    // liste = dao.findAll();
    // }
    // return liste;
    // }

}
