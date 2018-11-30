package fr.tp.cafe.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tp.cafe.domain.entity.Cafe;
import fr.tp.cafe.domain.entity.TypeCafe;

@Service
public class PersonneBusiness {

	private Cafe conso = null;

	@Autowired
	private MachineBusiness machineBusiness;

	/**
	 * Juste comme ça.
	 */
	public void parler() {
		System.out.println("blablabanbalba !");
	}

	/**
	 * Commander un café à la machine.
	 * 
	 * @param cafe
	 * @return
	 */
	public Cafe commander(TypeCafe cafe) {
		this.conso = machineBusiness.servir(cafe);
		return this.conso;
	}

	/**
	 * Boire le café de la machine.
	 */
	public void boire() {
		if (this.conso != null) {
			System.out.println("Je bois mon cafe : " + this.conso);
			return;
		}
		System.err.println("Il faut commander avant de consommer !");
	}
}
