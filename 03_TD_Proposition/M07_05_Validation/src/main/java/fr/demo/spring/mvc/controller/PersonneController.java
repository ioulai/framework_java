package fr.demo.spring.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.demo.spring.mvc.bean.Personne;

@Controller
public class PersonneController {

    @RequestMapping(method = RequestMethod.GET, path = "/formulaire")
    public ModelAndView getForm() {
        return new ModelAndView("formulaire", "pers", new Personne());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/formulaire")
    public String postForm(@Valid  @ModelAttribute("pers") Personne p, BindingResult result) {
        // @ModelAttribute("pers")
        System.out.println(p);
        System.out.println(result);
        if (result.hasErrors()) {
            return "formulaire";
        }
        return "success";
    }

}
