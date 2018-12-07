
package fr.eni.mvc.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.eni.mvc.bean.Style;
import fr.eni.mvc.service.GestionStyle;

@Controller
public class StyleController {

    @Autowired
    GestionStyle gs;

    @PostConstruct
    private void init() {
    }

    @RequestMapping(path = "/listerStyle", method = RequestMethod.GET)
    public ModelAndView listerStyle() {
        List<Style> listeS = gs.listeStyles();
        Style style = new Style();
        ModelAndView mav = new ModelAndView("listeStyles", "listeS", listeS);
        mav.getModelMap().addAttribute("style", style);
        return mav;
    }

    @RequestMapping(value = "/modifStyle", method = RequestMethod.POST)
    public ModelAndView modifStyle(Style s) {
        gs.modifierStyle(s);
        return listerStyle();
    }

    @RequestMapping(value = "/ajouterStyle", method = RequestMethod.POST)
    public ModelAndView ajoutFilmValid(Style style) {

        gs.ajoutStyle(style);

        return listerStyle();
    }

    @RequestMapping(value = "/trierStyle", method = RequestMethod.GET)
    public ModelAndView trierStyle(String par) {
        List<Style> listeS = gs.trier(par);
        Style style = new Style();
        ModelAndView mav = new ModelAndView("listeStyles", "listeS", listeS);
        mav.getModelMap().addAttribute("style", style);
        return mav;
    }

    @RequestMapping(value = "/supprimerStyle", method = RequestMethod.GET)
    public ModelAndView supprimerFilm(String index) {
        int i = Integer.parseInt(index.substring(1));
        Style style = gs.trouverStyle(i);
        try {
            gs.supprimerStyle(style);
        } catch (Exception e) {
        }

        return listerStyle();
    }

}
