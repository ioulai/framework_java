package fr.eni.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.jpa.bean.Region;
import fr.eni.jpa.dao.IRegionRepository;

@Service(value = "gr")
public class GestionRegion {

    @Autowired
    IRegionRepository regionDAO;

    public IRegionRepository getRegionDAO() {
        return regionDAO;
    }

    public void setRegionDAO(IRegionRepository regionDAO) {
        this.regionDAO = regionDAO;
    }

    public List<Region> getListeRegions() {
        return regionDAO.findAll();
    }

    public Region getRegion(int id) {
        return regionDAO.findOne(id);
    }

}
