package fr.eni.jpa.dao;

import java.util.List;

import fr.eni.jpa.bean.Tache;

public interface TacheDAO {

    public void ajoutStyle(Tache style) throws Exception;

    public void delete(Tache style) throws Exception;

    public void update(Tache style) throws Exception;

    public Tache findById(int id);

    public List<Tache> findAll();
    
}
