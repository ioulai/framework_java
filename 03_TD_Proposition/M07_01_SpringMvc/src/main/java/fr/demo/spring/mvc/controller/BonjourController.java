package fr.demo.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/bonjour")
public class BonjourController {

    @RequestMapping(method = RequestMethod.GET)
    public String bonjour() {
        // nom de la jsp
        return "bonjour";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello() {
        // nom de la jsp
        return "hello";
    }

}
