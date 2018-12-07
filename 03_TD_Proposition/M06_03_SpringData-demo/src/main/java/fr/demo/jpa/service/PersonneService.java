package fr.demo.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.demo.jpa.dao.PersonneDao;
import fr.demo.jpa.entity.PersonneEntity;

@Service // Nom du bean par defaut : personneService
public class PersonneService {

	@Autowired
	PersonneDao personneDao;

	public List<PersonneEntity> findAll() {
		return personneDao.findAll();
	}

	public PersonneEntity findById(int id) {
		return personneDao.findOne(id);
	}

	public void add(PersonneEntity p) {
		personneDao.save(p);
	}

	public void update(PersonneEntity p) {
		personneDao.save(p);
	}

	public void delete(PersonneEntity p) {
		personneDao.delete(p);
	}

	public void delete(int id) {
		personneDao.delete(id);
	}

	public void findParNom(String nom) {
		// TODO
//		personneDao.findByNom(nom);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public PersonneEntity findLast() {
//		return personneDao.findLast();
//	}
}
