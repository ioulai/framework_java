package fr.tp.cafe.domain.entity;

public abstract class CafeAbstract {

	private String nom;
	private String ingred;

	public CafeAbstract(String nom, String ingred) {
		super();
		this.nom = nom;
		this.ingred = ingred;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getIngred() {
		return ingred;
	}

	public void setIngred(String ingred) {
		this.ingred = ingred;
	}

	public void consommer() {
		System.out.println();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CafeAbstract [nom=");
		builder.append(nom);
		builder.append(", ingred=");
		builder.append(ingred);
		builder.append("]");
		return builder.toString();
	}
	
	
}
