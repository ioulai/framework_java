package fr.demo.jpa.entity;

import java.io.Serializable;

public class PersonnePk implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nom;
    private String prenom;

    public PersonnePk() {
    }

    public PersonnePk(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PersonnePk [nom=");
        builder.append(nom);
        builder.append(", prenom=");
        builder.append(prenom);
        builder.append("]");
        return builder.toString();
    }

}
