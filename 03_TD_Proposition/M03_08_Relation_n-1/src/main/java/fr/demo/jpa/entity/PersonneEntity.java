package fr.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Personne")
@Table(name = "personne")
public class PersonneEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;

    @ManyToOne
    private CiviliteEntity civilite;

    public PersonneEntity() {
    }

    public PersonneEntity(String nom, String prenom, CiviliteEntity civilite) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public CiviliteEntity getCivilite() {
        return civilite;
    }

    public void setCivilite(CiviliteEntity civilite) {
        this.civilite = civilite;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PersonneEntity [id=");
        builder.append(id);
        builder.append(", nom=");
        builder.append(nom);
        builder.append(", prenom=");
        builder.append(prenom);
        builder.append(", civilite=");
        builder.append(civilite);
        builder.append("]");
        return builder.toString();
    }

}
