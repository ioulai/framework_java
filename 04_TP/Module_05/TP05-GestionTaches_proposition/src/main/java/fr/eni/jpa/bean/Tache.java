package fr.eni.jpa.bean;

/**
 * Bean Tâche.
 * 
 * @author Gaël Sigogneau
 * @since 23 nov. 2018
 *
 */
public class Tache {

    private int id;
    private String libelle;
    private int importance;

    public Tache() {
    }

    public Tache(String libelle, int importance) {
        this.libelle = libelle;
        this.importance = importance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "Tache [id=" + id + ", libelle=" + libelle + ", importance=" + importance + "]";
    }

}
