package fr.eni.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.jpa.bean.Tache;

@Repository(value = "tacheDAO")
public class TacheDAOImpl implements TacheDAO {

    @Autowired
    JdbcTemplate jt;

    @Override
    public void ajoutStyle(Tache tache) throws Exception {
        String req = "insert into Tache (libelle, importance) values (?, ?)";
        jt.update(req, tache.getLibelle(), tache.getImportance());

    }

    @Override
    public void delete(Tache tache) throws Exception {
        String req = "delete from Tache where id = ?";
        jt.update(req, tache.getId());

    }

    @Override
    public void update(Tache tache) throws Exception {
        String req = "update Tache set libelle=?, importance=? where id=?";
        jt.update(req, tache.getLibelle(), tache.getImportance(), tache.getId());

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Tache findById(int id) {
        String req = "select * from Tache where id=?";
        return (Tache) jt.queryForObject(req, new Object[] { id }, new BeanPropertyRowMapper(Tache.class));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<Tache> findAll() {
        String req = "select * from Tache";
        return jt.query(req, new BeanPropertyRowMapper(Tache.class));
    }

}
