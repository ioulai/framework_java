package fr.eni.jpa.servlet;

import java.io.IOException;

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

@WebServlet("/afficher")
public class AfficherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    GestionBouteille gb;

    @Override
    public void init(ServletConfig config) throws ServletException {

        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String file = "/afficherB.jsp";

        try {
            String id = request.getParameter("index");
            int i = Integer.parseInt(id);
            Bouteille courant = gb.getBouteille(i);
            request.setAttribute("bout", courant);
        } catch (NumberFormatException e) {
            file = "lister";
        }

        RequestDispatcher rd = request.getRequestDispatcher(file);
        rd.forward(request, response);

    }

}
