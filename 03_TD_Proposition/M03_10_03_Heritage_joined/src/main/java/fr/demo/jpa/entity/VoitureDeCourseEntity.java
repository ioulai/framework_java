package fr.demo.jpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "course")
@Table(name = "course_table") // necessite une table pour le mode de fonctionnement
@DiscriminatorValue(value = "C") // valeur du discr pour cette entity
public class VoitureDeCourseEntity extends VoitureEntity {

    private static final long serialVersionUID = -8586320055289775255L;

    private String ecurie;

    public VoitureDeCourseEntity() {
        super();
    }

    public VoitureDeCourseEntity(String marque, String ecurie) {
        super(marque);
        this.ecurie = ecurie;
    }

    public String getEcurie() {
        return ecurie;
    }

    public void setEcurie(String ecurie) {
        this.ecurie = ecurie;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VoitureDeCourseEntity [ecurie=");
        builder.append(ecurie);
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
