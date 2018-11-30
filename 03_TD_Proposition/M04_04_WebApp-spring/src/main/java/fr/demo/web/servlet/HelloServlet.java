package fr.demo.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.demo.web.bo.Message;

/**
 * SERVLET HELLO WORLD.
 * Pour tester lancer le server Tomcat avec Getty et consulter : http://localhost:8080/M04_04_WebApp-spring/message
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
@WebServlet("/message")
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = -6666225414678188055L;

    @Autowired
    private Message message;

    /**
     * INIT DU CONTEXT.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    /**
     * GET REQUEST.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html><body><h1>" + message.getMsg() + "</h1></body></html>");
    }
}
