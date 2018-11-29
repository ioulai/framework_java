package fr.demo.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "berline")
@Table(name = "berline_table") // necessite une table pour le mode de fonctionnement
@DiscriminatorValue(value = "B") // valeur du discr pour cette entity
public class BerlineEntity extends VoitureEntity {

    private static final long serialVersionUID = -6756399982631212664L;

    @Column(name = "couleur_cuir")
    private String couleurCuir;

    public BerlineEntity() {
        super();
    }

    public BerlineEntity(String marque, String couleurCuir) {
        super(marque);
        this.couleurCuir = couleurCuir;
    }

    public String getCouleurCuir() {
        return couleurCuir;
    }

    public void setCouleurCuir(String couleurCuir) {
        this.couleurCuir = couleurCuir;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BerlineEntity [couleurCuir=");
        builder.append(couleurCuir);
        builder.append(", getId()=");
        builder.append(getId());
        builder.append(", getMarque()=");
        builder.append(getMarque());
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append(", getClass()=");
        builder.append(getClass());
        builder.append(", hashCode()=");
        builder.append(hashCode());
        builder.append("]");
        return builder.toString();
    }

}
