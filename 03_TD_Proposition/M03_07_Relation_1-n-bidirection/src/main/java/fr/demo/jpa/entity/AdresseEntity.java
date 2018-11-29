package fr.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Adresse")
@Table(name = "adresse")
public class AdresseEntity implements Serializable {

    private static final long serialVersionUID = -4977544991332488686L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codePostal;
    private String ville;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "personne_id")
    private PersonneEntity personne;

    public AdresseEntity() {
    }

    public AdresseEntity(String codePostal, String ville) {
        super();
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public AdresseEntity(String codePostal, String ville, PersonneEntity personne) {
        super();
        this.codePostal = codePostal;
        this.ville = ville;
        this.personne = personne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public PersonneEntity getPersonne() {
        return personne;
    }

    public void setPersonne(PersonneEntity personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AdresseEntity [id=");
        builder.append(id);
        builder.append(", codePostal=");
        builder.append(codePostal);
        builder.append(", ville=");
        builder.append(ville);
        builder.append("]");
        return builder.toString();
    }

}
