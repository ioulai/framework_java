package fr.eni.jpa.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.eni.jpa.bean.Bouteille;
import fr.eni.jpa.service.GestionBouteille;

/**
 * Servlet implementation class ListerServlet
 */
@WebServlet("/supprimer")
public class SupprimerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    GestionBouteille gb;

    @Override
    public void init(ServletConfig config) throws ServletException {

        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("index");
        int i = Integer.parseInt(id.substring(1));
        Bouteille courant = gb.getBouteille(i);
        gb.supprimerBouteille(courant);

        response.sendRedirect("lister");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
