package fr.demo.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Une entity configurée par Annotation.
 * 
 * @author Gaël Sigogneau
 * @since 21 nov. 2018
 *
 */
@Entity(name = "PersonneE")
@Table(name = "personne")
public class PersonneEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PersonnePk personnePk;

    @Column(name = "date_naissance", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar dateNaissance;

    @Transient
    private Integer age;

    public PersonneEntity() {
        setDateNaissance(null);
    }

    public PersonneEntity(PersonnePk personnePk) {
        super();
        this.personnePk = personnePk;
    }

    public PersonnePk getPersonnePk() {
        return personnePk;
    }

    public void setPersonnePk(PersonnePk personnePk) {
        this.personnePk = personnePk;
    }

    public Calendar getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Calendar dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PersonneEntity [personnePk=");
        builder.append(personnePk);
        builder.append(", dateNaissance=");
        builder.append(dateNaissance);
        builder.append(", age=");
        builder.append(age);
        builder.append("]");
        return builder.toString();
    }

}
