package fr.eni.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.jpa.bean.Bouteille;

public interface IBouteilleRepository extends JpaRepository<Bouteille, Integer> {

    Iterable<Bouteille> findAllByOrderByNomAsc();

    Iterable<Bouteille> findByNomContainingOrderByNomAsc(String nom);

    Iterable<Bouteille> findAllByOrderByNomDesc();

    Iterable<Bouteille> findAllByOrderByPetillantAsc();

    Iterable<Bouteille> findAllByOrderByPetillantDesc();

    Iterable<Bouteille> findAllByOrderByMillesimeAsc();

    Iterable<Bouteille> findAllByOrderByMillesimeDesc();

    Iterable<Bouteille> findAllByOrderByQuantiteAsc();

    Iterable<Bouteille> findAllByOrderByQuantiteDesc();

    Iterable<Bouteille> findAllByOrderByCouleurNomAsc();

    Iterable<Bouteille> findAllByOrderByCouleurNomDesc();

    Iterable<Bouteille> findAllByOrderByRegionNomAsc();

    Iterable<Bouteille> findAllByOrderByRegionNomDesc();

}
