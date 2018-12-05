package fr.eni.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.jpa.bean.Couleur;
import fr.eni.jpa.dao.ICouleurRepository;

@Service(value = "gc")
public class GestionCouleur {

    @Autowired
    ICouleurRepository couleurDAO;

    public ICouleurRepository getCouleurDAO() {
        return couleurDAO;
    }

    public void setCouleurDAO(ICouleurRepository couleurDAO) {
        this.couleurDAO = couleurDAO;
    }

    public List<Couleur> getListeCouleurs() {
        return (List<Couleur>) couleurDAO.findAllByOrderByNomAsc();
    }

    public Couleur getCouleur(int id) {
        return couleurDAO.findOne(id);
    }

}
