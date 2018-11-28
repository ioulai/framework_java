package fr.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Pays")
@Table(name = "pays")
public class PaysEntity implements Serializable {

    private static final long serialVersionUID = 8070807098850203862L;

    @Id
    @Column(name = "cle")
    private String key;

    private String libelle;

    public PaysEntity() {
    }

    public PaysEntity(String libelle) {
        super();
        this.libelle = libelle;
    }

    public PaysEntity(String cle, String libelle) {
        super();
        this.libelle = libelle;
        this.key = cle;
    }
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
        builder.append("PaysEntity [key=");
        builder.append(key);
        builder.append(", libelle=");
        builder.append(libelle);
        builder.append("]");
        return builder.toString();
    }

}
