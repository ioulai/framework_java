package fr.demo.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdresseEntity {

	@Id
	private int id;
	private String ville;
	public AdresseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
