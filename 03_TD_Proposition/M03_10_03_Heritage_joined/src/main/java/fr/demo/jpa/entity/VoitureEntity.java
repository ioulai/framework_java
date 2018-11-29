package fr.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name = "voiture")
@Table(name = "voiture_table")
@Inheritance(strategy = InheritanceType.JOINED) // mode d'héritage par jointure
@DiscriminatorColumn(name = "discr") // création d'un attribut discriminant
@DiscriminatorValue(value = "V") // valeur du discr pour cette entity
public class VoitureEntity implements Serializable {

    private static final long serialVersionUID = -4262123858146909305L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ATTENTION : on délègue la gestion de la clé à la base de données
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
