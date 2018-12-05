package fr.eni.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.jpa.bean.Couleur;

public interface ICouleurRepository extends JpaRepository<Couleur, Integer> {

    Iterable<Couleur> findAllByOrderByIdAsc();

    Iterable<Couleur> findAllByOrderByIdDesc();

    Iterable<Couleur> findAllByOrderByNomAsc();

    Iterable<Couleur> findAllByOrderByNomDesc();

}
