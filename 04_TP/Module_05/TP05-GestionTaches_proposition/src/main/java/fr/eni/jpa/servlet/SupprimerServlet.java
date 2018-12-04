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

import fr.eni.jpa.service.GestionTacheService;

/**
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/supprimerTache")
public class SupprimerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private GestionTacheService gt;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            gt.supprimerUneTache(Integer.parseInt(request.getParameter("index")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("listerTache");
    }

}
