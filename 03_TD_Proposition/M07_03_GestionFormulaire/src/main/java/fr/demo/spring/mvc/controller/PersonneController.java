package fr.demo.spring.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.demo.spring.mvc.bean.Adresse;
import fr.demo.spring.mvc.bean.Personne;

@Controller
@SessionAttributes({ "heureSession" })
public class PersonneController {

    // injection du ServletContext pour la démo sur les dates/heures
    @Autowired
    ServletContext context;

    // Injection de beans
    @Resource(name = "pers1")
    Personne pers1;
    @Resource(name = "pers2")
    Personne pers2;

    /**
     * Création d'un attribut dans le model spring.<br/>
     * getHeure sera exec à chaque tag jsp ${heure}.
     * 
     * @return
     */
    @ModelAttribute("heure")
    public String getHeure() {
        System.out.println("appel de getHeure");
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

    /**
     * Création d'un attribut dans le model spring. <br/>
     * getHeureSession sera exec à chaque NOUVELLE session utilisateur?
     * 
     * @return
     */
    @ModelAttribute("heureSession")
    public String getHeureSession() {
        System.out.println("appel de getHeureSession");
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

    /**
     * Exec d'une méthode avant le serverlet-dispatcher
     */
    @PostConstruct
    public void getHeureContexte() {
        System.out.println("appel de getHeureContexte");
        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        context.setAttribute("heureContext", date);
    }

    /**
     * GET REQUEST.
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/ajout")
    public ModelAndView ajout() {
        System.out.println("appel de ajout");
        Personne current = new Personne("LeGrand", "Lucie", new Adresse("44000", "nantes"));
        return new ModelAndView("ajout", "command", current);
    }

    /**
     * POST REQUEST.
     * 
     * @param p
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "/ajout")
    public ModelAndView ajoutPost(Personne p) {
        System.out.println("appel de ajoutPost");
        return new ModelAndView("success", "nouveau", p);
    }

    /**
     * Demo injection bean.
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/ajoutInjPers1")
    public ModelAndView ajoutInj1() {
        System.out.println("appel de ajoutInj1");
        return new ModelAndView("ajout", "command", pers1);
    }

    /**
     * Demo injection bean.
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/ajoutInjPers2")
    public ModelAndView ajoutInj2() {
        System.out.println("appel de ajoutInj2");
        return new ModelAndView("ajout", "command", pers2);
    }

    // @RequestMapping(method = RequestMethod.POST, path = "/ajoutAutre")
    // public String ajoutAutre(@ModelAttribute("nouveau") Personne p) {
    // System.out.println("appel de ajoutAutre");
    // return "success";
    // }

}
