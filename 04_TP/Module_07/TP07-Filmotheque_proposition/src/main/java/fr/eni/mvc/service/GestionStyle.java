package fr.eni.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.mvc.bean.Style;
import fr.eni.mvc.dao.StyleDAO;

@Service
public class GestionStyle {

    @Autowired
    StyleDAO dao;

    public List<Style> listeStyles() {
        return dao.findAll();
    }

    public Style trouverStyle(int i) {
        return dao.findOne(i);
    }

    public void ajoutStyle(Style s) {
        dao.save(s);
    }

    public void modifierStyle(Style s) {
        dao.save(s);
    }

    public void supprimerStyle(Style s) {
        dao.delete(s);
    }

    public List<Style> trier(String type) {
        List<Style> liste = null;
        switch (type) {
        case "iA":
            liste = dao.findByOrderByIdAsc();
            break;
        case "iD":
            liste = dao.findByOrderByIdDesc();
            break;
        case "lA":
            liste = dao.findByOrderByLibelleAsc();
            break;
        case "lD":
            liste = dao.findByOrderByLibelleDesc();
            break;
        default:
            liste = dao.findAll();
        }
        return liste;
    }

}
