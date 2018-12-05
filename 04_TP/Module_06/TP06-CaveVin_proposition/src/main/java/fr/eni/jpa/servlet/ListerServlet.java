package fr.eni.jpa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/lister")
public class ListerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    GestionBouteille gb;

    @Override
    public void init(ServletConfig config) throws ServletException {

        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bouteille> listeB = null;
        String filtre = request.getParameter("filtre");
        if (filtre != null && !filtre.trim().equals("")) {
            listeB = gb.getListeBouteillesParNom(filtre);
        } else {
            listeB = gb.getListeBouteilles();
        }

        request.setAttribute("listeB", listeB);
        RequestDispatcher rd = request.getRequestDispatcher("/listerB.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
