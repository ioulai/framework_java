package fr.demo.jpa.exception;

/**
 * Exception custom pour la couche DAL.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
public class DALException extends Exception {

    private static final long serialVersionUID = 1L;

    public DALException(String message) {
        super(message);
    }

}
