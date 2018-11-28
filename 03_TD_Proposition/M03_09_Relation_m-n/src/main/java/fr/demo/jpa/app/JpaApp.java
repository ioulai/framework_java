package fr.demo.jpa.app;

import fr.demo.jpa.dao.DaoUtil;
import fr.demo.jpa.dao.PaysDao;
import fr.demo.jpa.dao.PersonneDao;
import fr.demo.jpa.entity.PaysEntity;
import fr.demo.jpa.entity.PersonneEntity;
import fr.demo.jpa.exception.DALException;

/**
 * ClasseMain pour tester JPA.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class JpaApp {

    public static void main(String[] args) throws DALException {

        // ### Créer des jeux de tests
        PaysEntity fr = getPays("fr", "france");
        PaysEntity it = getPays("it", "Italie");
        PaysEntity gb = getPays("gb", "Grande Bretagne");

        PersonneEntity p1 = new PersonneEntity("Dupuis", "Romain");
        PersonneEntity p2 = new PersonneEntity("Gaston", "Lagaffe");

        p1.addPays(fr);
        p1.addPays(it);

        p2.addPays(fr);
        p2.addPays(gb);

        // ### sauvegarde en bdd
        PersonneDao.add(p1);
        PersonneDao.add(p2);

        // ### afficher les enregistrements
        System.out.println(">>> Après enregistrement");
        PersonneDao.findAll().forEach(System.out::println);

        // ### supprimer une relation
        p2.removePays(gb);

        // ### Modifier une relation
        p2.addPays(getPays("po", "portugal"));

        // commit changement
        PersonneDao.update(p2);
        System.out.println(">>> Après update");
        PersonneDao.findAll().forEach(System.out::println);

        // ### Fermer la connexion
        DaoUtil.close();
    }

    /**
     * Chercher un pays, sinon le créer en bdd.
     * 
     * @param cle
     * @param libelle
     * @return
     */
    private static PaysEntity getPays(String cle, String libelle) {
        PaysEntity p = PaysDao.findById(cle);
        if (p == null) {
            p = new PaysEntity(cle, libelle);
            try {
                PaysDao.add(p);
            } catch (DALException e) {
                e.printStackTrace();
            }
        }
        return p;
    }
}
