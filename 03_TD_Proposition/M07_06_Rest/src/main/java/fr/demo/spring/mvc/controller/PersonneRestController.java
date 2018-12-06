package fr.demo.spring.mvc.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fr.demo.spring.mvc.bean.Personne;
import fr.demo.spring.mvc.bean.Personnes;

/**
 * Controller REST.
 * 
 * @author Gaël Sigogneau
 * @since 24 nov. 2018
 *
 */
@RestController
@RequestMapping(value = "/personnes")
public class PersonneRestController {

    private Personnes personnes;

    /**
     * Avant la construction de la ressource.
     */
    @PostConstruct
    public void init() {
        personnes = new Personnes();
    }

    /**
     * GET = chercher une ressource. <br/>
     * URI = http://localhost:8080/M07_06_Rest/app/personnes/liste
     * 
     * @return
     */
    @RequestMapping(value = "/liste", method = RequestMethod.GET)
    public ResponseEntity<List<Personne>> getPersonnes() {
        return new ResponseEntity<List<Personne>>(personnes.getListe(), HttpStatus.OK);
    }

    /**
     * GET = chercher une ressource. <br/>
     * URI = http://localhost:8080/M07_06_Rest/app/personnes/1
     * 
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Personne> getPersonnes(@PathVariable("id") int id) {
        System.out.println("id=" + id);
        if (personnes.getListe().size() <= id) {
            // si l' id est inférieur à la taille de la liste = 404
            return new ResponseEntity<Personne>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Personne>(personnes.getListe().get(id), HttpStatus.OK);
    }

    /**
     * POST = Création d'une ressource. <br/>
     * URI = http://localhost:8080/M07_06_Rest/app/personnes BODY = { "nom": "Firebase", "prenom": "Firebase is awesome", "adresse" : { "codePostal" : "44000", "ville" : "Nantes" } }
     * 
     * @param id
     * @param p
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> postPersonne(@RequestBody Personne p, UriComponentsBuilder ucBuilder) {
        System.out.println(p);
        // créer la personne
        personnes.addPersonne(p);

        // Ecrire dans le header de la request
        int nb = personnes.getListe().size();
        HttpHeaders header = new HttpHeaders();
        header.setLocation(ucBuilder.path("/{id}").buildAndExpand(nb).toUri());
        return new ResponseEntity<Void>(header, HttpStatus.CREATED);
        // return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /**
     * DELETE = suppression d'une ressource.
     * 
     * @param id
     * @param p
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePersonne(@PathVariable int id) {
        System.out.println("suppression de id=" + id);
        // essayer de supprimer
        try {
            personnes.removePersonne(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    /**
     * PUT = mise à jour d'une ressource.
     * 
     * @param id
     * @param p
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Personne> udpatePersonne(@PathVariable int id, @RequestBody Personne p) {
        System.out.println("maj de id=" + id);
        System.out.println(p);
        if (personnes.getListe().size() <= id) {
            return new ResponseEntity<Personne>(HttpStatus.FOUND);
        }
        personnes.getListe().set(id, p);
        return new ResponseEntity<Personne>(personnes.getListe().get(id), HttpStatus.OK);
    }
}
