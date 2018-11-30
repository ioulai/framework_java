package fr.tp.cafe.domain.entity;

import org.springframework.stereotype.Component;

@Component
public class CafeLait extends CafeAbstract implements Cafe {

	private static final String TYPE = "CAFE AU LAIT";
	private static final String INGR = "EAU / CAFE / LAIT";

	public CafeLait() {
		super(TYPE, INGR);
	}

}
