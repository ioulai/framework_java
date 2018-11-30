package fr.tp.cafe.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tp.cafe.domain.entity.Cafe;
import fr.tp.cafe.domain.entity.CafeLait;
import fr.tp.cafe.domain.entity.CafeNoir;

@Service
public class CafeFactory {

	@Autowired
	private CafeNoir cafeNoir;
	@Autowired
	private CafeLait CafeLait;

	public Cafe getCafeNoir() {
		return this.cafeNoir;
	}

	public Cafe getCafeLait() {
		return this.CafeLait;
	}

}
