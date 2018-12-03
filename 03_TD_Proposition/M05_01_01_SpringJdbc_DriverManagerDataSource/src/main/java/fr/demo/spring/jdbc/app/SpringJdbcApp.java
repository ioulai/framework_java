package fr.demo.spring.jdbc.app;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        // ouvrir le contexte spring ~= container
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        DataSource ds = context.getBean("datasource", DataSource.class);
        
        for (int i = 0; i < 5; i++) {
            Connection conn = ds.getConnection();
            System.out.println("Connexion n°" + i + " : " + conn + " = différentes");
            conn.close();
        }
        
        // fermer le contexte Spring
        ((ClassPathXmlApplicationContext) context).close();
    }
}
