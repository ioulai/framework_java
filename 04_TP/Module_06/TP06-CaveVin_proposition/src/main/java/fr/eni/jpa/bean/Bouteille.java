package fr.eni.jpa.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BouteilleCave")
public class Bouteille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @ManyToOne
    private Region region;

    @ManyToOne
    private Couleur couleur;
    private boolean petillant;
    private String millesime;
    private int quantite;

    public Bouteille() {
        region = new Region();
        couleur = new Couleur();
    }

    public Bouteille(String nom, Region region, Couleur couleur, boolean petillant, String millesime, int quantite) {
        this.nom = nom;
        this.region = region;
        this.couleur = couleur;
        this.petillant = petillant;
        this.millesime = millesime;
        this.quantite = quantite;
    }

    public Bouteille(int id, String nom, Region region, Couleur couleur, boolean petillant, String millesime, int quantite) {
        this.id = id;
        this.nom = nom;
        this.region = region;
        this.couleur = couleur;
        this.petillant = petillant;
        this.millesime = millesime;
        this.quantite = quantite;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public boolean isPetillant() {
        return petillant;
    }

    public void setPetillant(boolean petillant) {
        this.petillant = petillant;
    }

    public String getMillesime() {
        return millesime;
    }

    public void setMillesime(String millesime) {
        this.millesime = millesime;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Bouteille [id=" + id + ", nom=" + nom + ", region=" + region + ", couleur=" + couleur + ", petillant=" + petillant + ", millesime=" + millesime + ", quantite=" + quantite + "]";
    }

}
