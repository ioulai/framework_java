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

@WebServlet("/modifTache")
public class ModifierServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private GestionTacheService gt;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Tache t = gt.trouverUneTache(Integer.parseInt(request.getParameter("id")));
            t.setLibelle(request.getParameter("libelle"));
            t.setImportance(Integer.parseInt(request.getParameter("importance")));
            gt.modifierUneTache(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("listerTache");
    }

}
