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

import fr.eni.jpa.bean.Tache;
import fr.eni.jpa.service.GestionTacheService;

@WebServlet("/ajouterTache")
public class AjouterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private GestionTacheService gs;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String libelle = request.getParameter("libelle");
            int importance = Integer.parseInt(request.getParameter("importance"));
            Tache s = new Tache(libelle, importance);
            gs.ajoutUneTache(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("listerTache");
    }

}
