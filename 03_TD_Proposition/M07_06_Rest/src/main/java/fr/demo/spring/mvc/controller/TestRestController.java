package fr.demo.spring.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {

    @RequestMapping(value = "/un", method = RequestMethod.GET)
    public ResponseEntity<Integer> getInt() {
        return new ResponseEntity<Integer>(new Integer(30), HttpStatus.OK);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("hello world", HttpStatus.OK);
    }

    @RequestMapping(value = "/hello/{nom}", method = RequestMethod.GET)
    public ResponseEntity<String> helloNom(@PathVariable("nom") String name) {
        return new ResponseEntity<String>("Hello " + name, HttpStatus.OK);
    }
}
