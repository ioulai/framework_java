package fr.demo.spring.orm.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Simple Entity
 * 
 * @author Gaël Sigogneau
 * @since 23 nov. 2018
 *
 */
@Entity
@Table(name = "personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

    public Personne() {
        super();
    }

    public Personne(String nom, String prenom, int age) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Personne(String nom, String prenom, int age, Adresse adresse) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Personne [id=");
        builder.append(id);
        builder.append(", nom=");
        builder.append(nom);
        builder.append(", prenom=");
        builder.append(prenom);
        builder.append(", age=");
        builder.append(age);
        builder.append(", adresse=");
        builder.append(adresse);
        builder.append("]");
        return builder.toString();
    }

}
