package fr.eni.mvc.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.eni.mvc.bean.Film;
import fr.eni.mvc.bean.Style;
import fr.eni.mvc.service.GestionFilm;
import fr.eni.mvc.service.GestionStyle;

@Controller
public class FilmController {

    @Autowired
    GestionFilm gf;
    @Autowired
    GestionStyle gs;

    @PostConstruct
    private void init() {
    }

    @RequestMapping(path = "/lister", method = RequestMethod.GET)
    public ModelAndView afficherFilms() {
        List<Film> listeF = gf.listeFilms();
        return new ModelAndView("listeFilms", "listeF", listeF);
    }

    @RequestMapping(value = "/trier", method = RequestMethod.GET)
    public ModelAndView trierFilm(String par) {
        List<Film> listeF = gf.trier(par);
        return new ModelAndView("listeFilms", "listeF", listeF);
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public ModelAndView ajouterFilm() {
        Film f = new Film();
        ModelAndView mav = new ModelAndView("ajouterFilm", "film", f);
        List<Style> listeStyles = gs.listeStyles();
        mav.getModelMap().addAttribute("listeStyles", listeStyles);
        return mav;
    }

    @RequestMapping(value = "/ajouterValid", method = RequestMethod.POST)
    public ModelAndView ajoutFilmValid(Film film, ModelMap model) {

        gf.ajoutFilm(film);

        return afficherFilms();
    }

    @RequestMapping(value = "/supprimer", method = RequestMethod.GET)
    public ModelAndView supprimerFilm(String index) {
        int i = Integer.parseInt(index.substring(1));
        Film courant = gf.trouverFilm(i);
        gf.supprimerFilm(courant);

        return afficherFilms();
    }

    @RequestMapping(value = "/afficher", method = RequestMethod.GET)
    public ModelAndView afficher(Integer index) {
        Film film = null;
        if (index != null) {
            film = gf.trouverFilm(index);
            return new ModelAndView("afficherFilm", "film", film);
        } else
            return afficherFilms();
    }

    @RequestMapping(value = "/editer", method = RequestMethod.GET)
    public ModelAndView editerFilm(String index) {
        int i = Integer.parseInt(index.substring(1));
        ModelAndView mav = new ModelAndView("editerFilm", "film", gf.trouverFilm(i));
        List<Style> listeStyles = gs.listeStyles();
        mav.getModelMap().addAttribute("listeStyles", listeStyles);
        return mav;
    }

    @RequestMapping(value = "/editerValid", method = RequestMethod.POST)
    public ModelAndView listeBouteilleValid(Film f) {
        // System.out.println(f);
        gf.modifierFilm(f);
        return afficherFilms();
    }

}
