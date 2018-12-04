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

import fr.eni.jpa.bean.Tache;
import fr.eni.jpa.service.GestionTacheService;

@WebServlet("/listerTache")
public class ListeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private GestionTacheService gt;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Tache> listeT = gt.listeAllTaches();

        Tache tache = new Tache();
        request.setAttribute("listeT", listeT);
        request.setAttribute("tache", tache);

        RequestDispatcher rd = request.getRequestDispatcher("/listeTaches.jsp");
        rd.forward(request, response);

    }

}
