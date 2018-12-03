package fr.demo.spring.jdbc.app;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.demo.spring.jdbc.bean.Personne;

/**
 * Demonstration de code avec SpringJdbc.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
public class SpringJdbcApp {

    /**
     * MainEntry.
     * 
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {

        // ### ouvrir le contexte spring ~= container
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DataSource ds = context.getBean("datasource", DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);

        // ### TEST DES REQUESTS
        System.out.println("\n>>> queryForListNom");
        queryForListNom(jt).forEach(System.out::println);

        System.out.println("\n>>> queryForListPrenom");
        queryForListPrenom(jt, "a").forEach(System.out::println);

        System.out.println("\n>>> queryNbElement = " + queryNbElement(jt));

        System.out.println("\n>>> queryNbElementAgeEntre = " + queryNbElementAgeEntre(jt, 40, 50));

        System.out.println("\n>>> queryNbElementAgeEntre2 = " + queryNbElementAgeEntre2(jt, 40, 50));

        System.out.println("\n>>> findAll");
        findAll(jt).forEach(System.out::println);

        System.out.println("\n>>> findAllAgeEntre2");
        findAllAgeEntre2(jt, 40, 50).forEach(System.out::println);

        System.out.println("\n>>> add");
        Personne gaston = new Personne("Gaston", "Lagaffe", 25);
        add(jt, gaston);
        findAll(jt).forEach(System.out::println);

        System.out.println("\n>>> update");
        gaston.setAge(30);
        update(jt, gaston);
        findAll(jt).forEach(System.out::println);

        System.out.println("\n>>> delete");
        delete(jt, 1);
        findAll(jt).forEach(System.out::println);

        // ### Tester les exception
        queryForListNomTestException(jt);

        // ### Démo requête param
        utiliserLesRequestsParametre(ds);

        // ### fermer la connexion Singleton depuis la dataSource
        ds.getConnection().close();
        ((ClassPathXmlApplicationContext) context).close();
    }

    private static List<String> queryForListNom(JdbcTemplate jt) {
        return jt.queryForList("SELECT nom FROM personne", String.class);
    }

    private static List<String> queryForListPrenom(JdbcTemplate jt, String chaine) {
        return jt.queryForList("SELECT prenom FROM personne WHERE prenom LIKE ?", String.class, "%" + chaine + "%");
    }

    private static Integer queryNbElement(JdbcTemplate jt) {
        return jt.queryForObject("SELECT COUNT(*) FROM personne", Integer.class);
    }

    private static Integer queryNbElementAgeEntre(JdbcTemplate jt, int age1, int age2) {
        return jt.queryForObject("SELECT COUNT(*) FROM personne WHERE age > ? AND age < ?", Integer.class, age1, age2);
    }

    private static Integer queryNbElementAgeEntre2(JdbcTemplate jt, int age1, int age2) {
        return jt.queryForObject("SELECT COUNT(*) FROM personne WHERE age > ? AND age < ?", new Object[] { age1, age2 }, Integer.class);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static List<Personne> findAll(JdbcTemplate jt) {
        // BeanPropertyRowMapper : Permet de mapper un objet Java avec une ligne retournée par une requête SQL
        return jt.query("SELECT id, nom, prenom, age FROM personne", new BeanPropertyRowMapper(Personne.class));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static List<Personne> findAllAgeEntre2(JdbcTemplate jt, int age1, int age2) {
        return jt.query("SELECT * FROM personne WHERE age > ? AND age < ?", new Object[] { age1, age2 }, new BeanPropertyRowMapper(Personne.class));
    }

    private static void add(JdbcTemplate jt, Personne p) {
        jt.update("INSERT INTO personne(nom, prenom, age) VALUES (?, ?, ?)", p.getNom(), p.getPrenom(), p.getAge());
    }

    private static void update(JdbcTemplate jt, Personne p) {
        jt.update("UPDATE personne SET nom=?, prenom=?, age=? WHERE id=?", p.getNom(), p.getPrenom(), p.getAge(), p.getId());
    }

    private static void delete(JdbcTemplate jt, int id) {
        jt.update("DELETE FROM personne WHERE id = ?", id);
    }

    /**
     * Démonstration pour le traitement des erreurs jdbc.
     * 
     * @param jt
     * @return
     */
    private static List<String> queryForListNomTestException(JdbcTemplate jt) {
        List<String> result = null;
        try {
            result = jt.queryForList("SELECT p.nom FROM personne p2", String.class);
        } catch (BadSqlGrammarException e) {
            System.out.println("Msg getMessage : " + e.getMessage());
            System.out.println("Msg getRootCause : " + e.getRootCause());
            System.out.println("Msg getErrorCode : " + e.getSQLException().getErrorCode());
            System.out.println("Msg getMessage : " + e.getSQLException().getMessage());
            System.out.println("Msg getSQLState : " + e.getSQLException().getSQLState());
        }
        return result;
    }

    /**
     * Démo d'une requete paramétrée.
     * 
     * @param ds
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void utiliserLesRequestsParametre(DataSource ds) {
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(ds);
        MapSqlParameterSource vparams = new MapSqlParameterSource();
        vparams.addValue("ageMin", 35);
        vparams.addValue("ageMax", 50);

        String sql = "SELECT * FROM personne WHERE age > :ageMin AND age < :ageMax";
        List<Personne> result = npjt.query(sql, vparams, new BeanPropertyRowMapper(Personne.class));

        System.out.println("\n>>> utiliserLesRequestsParametre");
        result.forEach(System.out::println);
    }

}
