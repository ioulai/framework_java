package fr.demo.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "berline")
@DiscriminatorValue(value = "B") // nécessite un discriminant pour identifier l'entity dans la bdd
public class BerlineEntity extends VoitureEntity {

    private static final long serialVersionUID = 8361267733757261302L;

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
