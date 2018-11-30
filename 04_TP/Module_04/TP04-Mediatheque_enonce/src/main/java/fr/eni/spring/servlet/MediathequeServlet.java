package fr.eni.spring.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// la route de la servlet doit être "/*"
public class MediathequeServlet {

    /**
     * RESSOURCES POUR LA METHODE POST
     */
    protected void ressourcesPourLeTP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // nous avons appris la méthode doGet, peut être que le POST fonctionne de la même manière? 
        // consulter le code source de HttpServlet pour savoir... 
        
        // récupérer un paramètre dans la request
        String monParam = request.getParameter("monParam");

        // bind d'un obj entre la servelet et la vue
        request.getSession().setAttribute("monPetitNom", monObj);

        // préparer une ressource web pour re-dispartcher la request.
        RequestDispatcher rd = request.getRequestDispatcher("/mavue.jsp");

        // redirection vers la ressource
        rd.forward(request, response);
    }

}
