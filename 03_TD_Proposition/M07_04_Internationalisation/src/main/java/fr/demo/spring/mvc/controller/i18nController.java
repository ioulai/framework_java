package fr.demo.spring.mvc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
public class i18nController {

    @Autowired
    private SessionLocaleResolver slr;

    // injection pour test de lecture du fichier properties
    @Autowired
    private MessageSource ms;

    /**
     * Le Controller passe des paramètres directements au model ET à la vue.
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/i18n")
    public String testi18n(String lg, ModelMap map) {
        Locale locale = new Locale(lg);
        slr.setDefaultLocale(locale);

        System.out.println("Diplaylanguage = " + locale.getDisplayLanguage());
        System.out.println("language = " + locale.getLanguage());

        // test de lecture du fichier properties
        String msg1 = ms.getMessage("index.bonjour", null, locale);
        String msg2 = ms.getMessage("index.bienvenue", null, locale);
        String msg3 = ms.getMessage("hello", new String[] { "Fred", "LeGrand" }, locale);
        System.out.println("msg1=" + msg1);
        System.out.println("msg2=" + msg2);
        System.out.println("msg3=" + msg3);

        map.addAttribute("nom", "LePetit");
        map.addAttribute("prenom", "Fredou");

        // get jsp
        return "i18n";

    }

}
