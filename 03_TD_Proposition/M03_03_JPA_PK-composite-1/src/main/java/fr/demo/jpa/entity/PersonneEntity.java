package fr.demo.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Une entity configurée par Annotation.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
@Entity(name = "PersonneE")
@Table(name = "personne")
@IdClass(PersonnePk.class)
public class PersonneEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String nom;

    @Id
    private String prenom;

    @Column(name = "date_naissance", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar dateNaissance;

    @Transient
    private Integer age;

    public PersonneEntity() {
        setDateNaissance(null);
    }

    public PersonneEntity(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        setDateNaissance(null);
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

    public Calendar getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Calendar dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PersonneEntity [nom=");
        builder.append(nom);
        builder.append(", prenom=");
        builder.append(prenom);
        builder.append(", dateNaissance=");
        builder.append(dateNaissance);
        builder.append(", age=");
        builder.append(age);
        builder.append("]");
        return builder.toString();
    }

}
