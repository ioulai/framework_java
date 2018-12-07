package fr.demo.spring.mvc.bean;

import java.util.ArrayList;
import java.util.List;

public class Personnes {

    private List<Personne> liste = new ArrayList<>();

    public Personnes() {
    }

    public Personnes(List<Personne> personnes) {
        super();
        this.liste = personnes;
    }

    public List<Personne> getListe() {
        return liste;
    }

    public void setListe(List<Personne> liste) {
        this.liste = liste;
    }

    public void addPersonne(Personne p) {
        liste.add(p);
    }

    public void removePersonne(Personne p) {
        liste.remove(p);
    }

    public void removePersonne(int id) {
        liste.remove(id);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Personnes [personnes=");
        builder.append(liste);
        builder.append("]");
        return builder.toString();
    }

}
