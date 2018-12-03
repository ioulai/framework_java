package fr.demo.spring.jdbc.app;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.demo.spring.jdbc.dao.PersonneDao;

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

        // @Autowired impossible ici car SpringJdbcApp est hors context Spring
        PersonneDao dao = context.getBean("personneDao", PersonneDao.class);

        dao.getPersonnes().forEach(System.out::println);

        // ### fermer la connexion Singleton depuis la dataSource
        ds.getConnection().close();
        ((ClassPathXmlApplicationContext) context).close();
    }

}
