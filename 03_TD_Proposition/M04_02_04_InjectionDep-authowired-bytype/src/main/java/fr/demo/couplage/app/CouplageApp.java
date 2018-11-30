package fr.demo.couplage.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.demo.couplage.musicien.bo.Musicien;

/**
 * Demonstration de code avec un couplage FAIBLE.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
public class CouplageApp {

    /**
     * MainEntry.
     * 
     * @param args
     */
    public static void main(String[] args) {

        // ouvrir le contexte spring ~= container
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Musicien m1 = context.getBean("musicien", Musicien.class);
        m1.jouerMorceau();

        // fermer le contexte Spring
        ((ClassPathXmlApplicationContext) context).close();
    }
}
