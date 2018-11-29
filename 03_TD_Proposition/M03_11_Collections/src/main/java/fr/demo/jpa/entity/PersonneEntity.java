package fr.demo.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * Une entity configurée par Annotation.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
@Entity(name = "Personne")
@Table(name = "personne")
public class PersonneEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private String prenom;

    @ElementCollection
    // name = nom_de_la_table | name = nom_col_id_coté_sport | referencedColumnName = col_coté_personne
    @CollectionTable(name = "sports_collection", joinColumns = @JoinColumn(name = "id_personne", referencedColumnName = "id"))
    // name = nom_de_la_col
    @Column(name = "sport_col")
    private List<String> sports;

    public PersonneEntity() {
        setSports(null);
    }

    public PersonneEntity(String nom, String prenom, List<String> sports) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.sports = sports;
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

    public List<String> getSports() {
        return sports;
    }

    public void setSports(List<String> sports) {
        this.sports = sports;
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
        builder.append(", sports=");
        builder.append(sports);
        builder.append("]");
        return builder.toString();
    }

}
