package fr.eni.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.jpa.bean.Bouteille;
import fr.eni.jpa.dao.IBouteilleRepository;

@Service(value = "gb")
public class GestionBouteille {

    @Autowired
    IBouteilleRepository bouteilleDAO;

    public Bouteille getBouteille(int id) {
        return bouteilleDAO.findOne(id);
    }

    public IBouteilleRepository getBouteilleDAO() {
        return bouteilleDAO;
    }

    public void setBouteilleDAO(IBouteilleRepository bouteilleDAO) {
        this.bouteilleDAO = bouteilleDAO;
    }

    public void ajouterBouteille(Bouteille b) {
        bouteilleDAO.save(b);
    }

    public void modifierBouteille(Bouteille b) {
        bouteilleDAO.save(b);
    }

    public void supprimerBouteille(Bouteille b) {
        bouteilleDAO.delete(b);
    }

    public void supprimerBouteille(int index) {
        supprimerBouteille(bouteilleDAO.getOne(index));
    }

    public List<Bouteille> getListeBouteilles() {
        return bouteilleDAO.findAll();
    }

    public List<Bouteille> getListeBouteillesParNom(String nom) {
        return (List<Bouteille>) bouteilleDAO.findByNomContainingOrderByNomAsc(nom);
    }

    public List<Bouteille> triParPetillantAsc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByPetillantAsc();
    }

    public List<Bouteille> triParPetillantDesc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByPetillantDesc();
    }

    public List<Bouteille> triParNomAsc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByNomAsc();
    }

    public List<Bouteille> triParNomDesc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByNomDesc();
    }

    public List<Bouteille> triParMillesimeAsc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByMillesimeAsc();
    }

    public List<Bouteille> triParMillesimeDesc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByMillesimeDesc();
    }

    public List<Bouteille> triParQuantiteAsc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByQuantiteAsc();
    }

    public List<Bouteille> triParQuantiteDesc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByQuantiteDesc();
    }

    public List<Bouteille> triParCouleurAsc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByCouleurNomAsc();
    }

    public List<Bouteille> triParCouleurDesc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByCouleurNomDesc();
    }

    public List<Bouteille> triParRegionAsc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByRegionNomAsc();
    }

    public List<Bouteille> triParRegionDesc() {
        return (List<Bouteille>) bouteilleDAO.findAllByOrderByRegionNomDesc();
    }

}
