package fr.demo.spring.mvc.bean;

public class Adresse {

    private String codePostal;
    private String ville;

    public Adresse() {
    }

    public Adresse(String codePostal, String ville) {
        super();
        this.codePostal = codePostal;
        this.ville = ville;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Adresse [codePostal=");
        builder.append(codePostal);
        builder.append(", ville=");
        builder.append(ville);
        builder.append("]");
        return builder.toString();
    }

}
