package fr.eni.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.jpa.bean.Region;

public interface IRegionRepository extends JpaRepository<Region, Integer> {

    Iterable<Region> findAllByOrderByIdAsc();

    Iterable<Region> findAllByOrderByIdDesc();

    Iterable<Region> findAllByOrderByNomAsc();

    Iterable<Region> findAllByOrderByNomDesc();

}
