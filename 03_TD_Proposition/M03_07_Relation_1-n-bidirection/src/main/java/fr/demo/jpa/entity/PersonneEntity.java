package fr.demo.jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Personne")
@Table(name = "personne")
public class PersonneEntity implements Serializable {

    private static final long serialVersionUID = 8398772241102624478L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "personne", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdresseEntity> adresse = new ArrayList<>();

    public PersonneEntity() {
        setAdresse(null);
    }

    public PersonneEntity(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }

    public PersonneEntity(String nom, String prenom, List<AdresseEntity> adresses) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        setAdresse(adresses);
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

    public List<AdresseEntity> getAdresse() {
        return adresse;
    }

    public void setAdresse(List<AdresseEntity> adresse) {
        // for (AdresseEntity adresseEntity : adresse) {
        // try {
        // AdresseDao.add(adresseEntity);
        // } catch (DALException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // }
        this.adresse = adresse;
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
        builder.append(", adresse=");
        builder.append(adresse);
        builder.append("]");
        return builder.toString();
    }

}
