package fr.tp.cafe.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tp.cafe.business.MachineBusiness;
import fr.tp.cafe.business.PersonneBusiness;
import fr.tp.cafe.domain.entity.TypeCafe;

@Service("world")
public class WorldApi {

	@Autowired
	private MachineBusiness machineBusiness;
	@Autowired
	private PersonneBusiness personneBusiness;
	
	public void bigBang() {
		
		machineBusiness.allumer();

		personneBusiness.commander(TypeCafe.NOIR);
		
		personneBusiness.boire();
		
		machineBusiness.eteindre();
		
	}

}
