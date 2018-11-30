package fr.tp.cafe.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tp.cafe.domain.CafeFactory;
import fr.tp.cafe.domain.entity.Cafe;
import fr.tp.cafe.domain.entity.TypeCafe;

@Service
public class MachineBusiness {

	@Autowired
	private CafeFactory cafeFactory;

	public void allumer() {
		System.out.println("Boot de la machine...");
	}

	public void eteindre() {
		System.out.println("Shutdown de la machine...");
	}

	/**
	 * Commander un café à la machine.
	 * 
	 * @param commandeClient
	 * @return
	 */
	public Cafe servir(TypeCafe commandeClient) {
		if (TypeCafe.LAIT.equals(commandeClient)) {
			// utiliser le module de fabrication de la machine
			return cafeFactory.getCafeLait();
		}
		return cafeFactory.getCafeNoir();
	}
}
