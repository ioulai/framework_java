package fr.demo.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.demo.spring.jdbc.bean.Personne;

/**
 * Déclarer cette classe comme un Repository SPRING. Permet l'injection de DAOs.
 * 
 * @author Gaël Sigogneau
 * @since 23 nov. 2018
 *
 */
@Repository(value = "personneDao")
public class PersonneDaoImpl implements PersonneDao {

    // Injection de JdbcTemplate
    @Autowired
    private JdbcTemplate jt;

    @Override
    public void addPersonne(Personne p) {
        jt.update("INSERT INTO personne(nom, prenom, age) VALUES (?, ?, ?)", p.getNom(), p.getPrenom(), p.getAge());
    }

    @Override
    public void deletePersonne(Personne p) {
        jt.update("DELETE FROM personne WHERE id = ?", p.getId());
    }

    @Override
    public void updatePersonne(Personne p) {
        jt.update("UPDATE personne SET nom=?, prenom=?, age=? WHERE id=?", p.getNom(), p.getPrenom(), p.getAge(), p.getId());
    }

    @Override
    public Personne getPersonne(int id) {
        return jt.queryForObject("SELECT * FROM personne WHERE id=?", new Object[] { id }, new BeanPropertyRowMapper<>(Personne.class));
    }

    @Override
    public List<Personne> getPersonnes() {
        return jt.query("SELECT * FROM personne", new BeanPropertyRowMapper<>(Personne.class));
    }

}
