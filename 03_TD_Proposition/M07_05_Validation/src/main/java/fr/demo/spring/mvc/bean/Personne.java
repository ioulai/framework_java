package fr.demo.spring.mvc.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Personne {

    @NotBlank(message = "ne doit pas être vide")
    private String nom;

    @Email(message = " format mail incorrect")
    private String email;

    @Pattern(regexp = "^[0-9]{5}$", message = "format codepostal")
    private String codePostal;

    @Min(value = 0, message = "val min = 0")
    @Max(value = 100, message = "val max = 100")
    private int age;

    public Personne() {
    }

    public Personne(String nom, String email, String codePostal, int age) {
        super();
        this.nom = nom;
        this.email = email;
        this.codePostal = codePostal;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Personne [nom=");
        builder.append(nom);
        builder.append(", email=");
        builder.append(email);
        builder.append(", codePostal=");
        builder.append(codePostal);
        builder.append(", age=");
        builder.append(age);
        builder.append("]");
        return builder.toString();
    }

}
