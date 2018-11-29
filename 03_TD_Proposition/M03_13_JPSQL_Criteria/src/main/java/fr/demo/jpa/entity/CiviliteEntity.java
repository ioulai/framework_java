package fr.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Civilite")
@Table(name = "civilite")
public class CiviliteEntity implements Serializable {

    private static final long serialVersionUID = -5989597942660780631L;

    @Id
    private String cle;
    private String libelle;

    public CiviliteEntity() {
    }

    public CiviliteEntity(String cle, String libelle) {
        super();
        this.cle = cle;
        this.libelle = libelle;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CiviliteEntity [cle=");
        builder.append(cle);
        builder.append(", libelle=");
        builder.append(libelle);
        builder.append("]");
        return builder.toString();
    }

}
