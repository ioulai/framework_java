package fr.demo.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    /**
     * Le Controller passe des paramètres directements au model ET à la vue.
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public ModelAndView hello() {
        // view (jsp) | model | result
        ModelAndView mav = new ModelAndView("hello", "msg", "Message de HelloController");
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/bonjour")
    public ModelAndView bonjourNom(String nom) {
        // view (jsp) | model | result
        ModelAndView mav = new ModelAndView("hello", "msg", "Message de HelloController pour " + nom);
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/ajout")
    public ModelAndView ajout(String nomName, String prenomName) {
        // view (jsp) | model | result
        ModelAndView mav = new ModelAndView("hello", "msg", "Message de HelloController<br/>Nom=" + nomName + " Prenom=" + prenomName);
        return mav;
    }

}
