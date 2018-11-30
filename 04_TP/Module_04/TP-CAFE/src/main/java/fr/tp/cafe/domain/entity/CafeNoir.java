package fr.tp.cafe.domain.entity;

import org.springframework.stereotype.Component;

@Component
public class CafeNoir extends CafeAbstract implements Cafe {

	private static final String TYPE = "CAFE NOIR";
	private static final String INGR = "EAU / CAFE";

	public CafeNoir() {
		super(TYPE, INGR);
	}

}
