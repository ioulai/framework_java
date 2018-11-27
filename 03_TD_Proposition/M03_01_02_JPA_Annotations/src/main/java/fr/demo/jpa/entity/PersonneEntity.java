package fr.demo.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity
@Table(name = "personne")
public class PersonneEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", nullable = false, unique = true, length = 50)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 50)
    // @Basic(fetch = FetchType.LAZY)
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
        builder.append("PersonneEntity [id=");
        builder.append(id);
        builder.append(", nom=");
        builder.append(nom);
        builder.append(", prenom=");
        builder.append(prenom);
        builder.append(", dateNaissance=");
        builder.append(dateNaissance);
        builder.append("]");
        return builder.toString();
    }

}
