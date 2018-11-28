package fr.demo.jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Personne")
@Table(name = "personne")
public class PersonneEntity implements Serializable {

    private static final long serialVersionUID = -8450854982383795367L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;

    @ManyToMany
    @JoinTable(name = "PersonnePays", joinColumns = { @JoinColumn(name = "personne_id") }, inverseJoinColumns = { @JoinColumn(name = "pays_id") })
    private List<PaysEntity> paysVisites = new ArrayList<>();

    public PersonneEntity() {
    }

    public PersonneEntity(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }

    public PersonneEntity(String nom, String prenom, List<PaysEntity> paysVisites) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.paysVisites = paysVisites;
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

    public List<PaysEntity> getPaysVisites() {
        return paysVisites;
    }

    public void setPaysVisites(List<PaysEntity> paysVisites) {
        this.paysVisites = paysVisites;
    }

    public void addPays(PaysEntity pays) {
        this.paysVisites.add(pays);
    }

    public void removePays(PaysEntity pays) {
        this.paysVisites.remove(pays);
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
        builder.append(", paysVisites=");
        builder.append(paysVisites);
        builder.append("]");
        return builder.toString();
    }

}
