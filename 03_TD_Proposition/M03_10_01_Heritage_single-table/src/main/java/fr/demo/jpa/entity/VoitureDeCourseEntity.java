package fr.demo.jpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "course")
@DiscriminatorValue(value = "C") // nécessite un discriminant pour identifier l'entity dans la bdd
public class VoitureDeCourseEntity extends VoitureEntity {

    private static final long serialVersionUID = 7717969970873310240L;
    
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
