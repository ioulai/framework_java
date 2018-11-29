package fr.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name = "voiture")
@Table(name = "voiture_table")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VoitureEntity implements Serializable {

    private static final long serialVersionUID = -4262123858146909305L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // ATTENTION : on délègue la gestion de la clé aux procédures hibernate
    private int id;

    private String marque;

    public VoitureEntity() {
    }

    public VoitureEntity(String marque) {
        super();
        this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VoitureEntity [id=");
        builder.append(id);
        builder.append(", marque=");
        builder.append(marque);
        builder.append("]");
        return builder.toString();
    }

}
