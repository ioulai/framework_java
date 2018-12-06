package fr.demo.spring.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/heure")
public class HeureController {

    /**
     * Le Controller passe des paramètres au model seulement.
     * 
     * @param map
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String bonjour(ModelMap map) {
        
        // créer une date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String chaine = sdf.format(new Date());
        // ajouter la date au model
        map.addAttribute("heureFormate", chaine);
        
        // créer une liste
        List<String> maListe = new ArrayList<>();
        maListe.add("A");
        maListe.add("B");
        maListe.add("C");
        // ajouter la liste au model
        map.addAttribute("liste", maListe);
        
        // get jsp file
        return "dateHeure";
    }

}
