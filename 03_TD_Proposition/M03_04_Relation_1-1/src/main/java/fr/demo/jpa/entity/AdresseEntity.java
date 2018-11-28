package fr.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Adresse")
@Table(name = "adresse")
public class AdresseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codePostal;
    private String ville;

    public AdresseEntity() {
    }

    public AdresseEntity(String codePostal, String ville) {
        super();
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
