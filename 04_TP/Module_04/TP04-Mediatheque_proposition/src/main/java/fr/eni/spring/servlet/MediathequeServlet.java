package fr.eni.spring.servlet;

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

import fr.eni.spring.bean.Media;
import fr.eni.spring.bean.Mediatheque;

@WebServlet("/*")
public class MediathequeServlet extends HttpServlet {

	@Autowired
	Mediatheque mediatheque;

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// init context spring dans la servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String titre = request.getParameter("titre");

		// validateur manuel --> save on "database"
		if (nom != null && titre != null && nom.trim().length() > 0 && titre.trim().length() > 0) {
			Media m = new Media(titre, nom);
			mediatheque.getCollection().add(m);
		}

		request.getSession().setAttribute("mediatheque", mediatheque);

		RequestDispatcher rd = request.getRequestDispatcher("/affiche.jsp");
		rd.forward(request, response);

	}
}
