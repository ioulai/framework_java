package fr.demo.spring.mvc.bean;

public class Personne {

    private String nom;
    private String prenom;
    private Adresse adresse;

    public Personne() {
        this("", "", new Adresse());
    }

    public Personne(String nom, String prenom, Adresse adresse) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Personne [nom=");
        builder.append(nom);
        builder.append(", prenom=");
        builder.append(prenom);
        builder.append(", adresse=");
        builder.append(adresse);
        builder.append("]");
        return builder.toString();
    }

}
