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
@WebServlet("/trier")
public class TrierServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    GestionBouteille gb;

    @Override
    public void init(ServletConfig config) throws ServletException {

        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String par = request.getParameter("par");
        List<Bouteille> listeB = null;

        switch (par) {
        case "dA":
            listeB = gb.triParNomAsc();
            break;

        case "dD":
            listeB = gb.triParNomDesc();
            break;

        case "cA":
            listeB = gb.triParPetillantAsc();
            break;
        case "cD":
            listeB = gb.triParPetillantDesc();
            break;

        case "mA":
            listeB = gb.triParMillesimeAsc();
            break;
        case "mD":
            listeB = gb.triParMillesimeDesc();
            break;

        case "nA":
            listeB = gb.triParQuantiteAsc();
            break;
        case "nD":
            listeB = gb.triParQuantiteDesc();
            break;

        case "coA":
            listeB = gb.triParCouleurAsc();
            break;
        case "coD":
            listeB = gb.triParCouleurDesc();
            break;

        case "rA":
            listeB = gb.triParRegionAsc();
            break;
        case "rD":
            listeB = gb.triParRegionDesc();
            break;

        default:
            listeB = gb.getListeBouteilles();
            break;
        }

        request.setAttribute("listeB", listeB);
        RequestDispatcher rd = request.getRequestDispatcher("/listerB.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
