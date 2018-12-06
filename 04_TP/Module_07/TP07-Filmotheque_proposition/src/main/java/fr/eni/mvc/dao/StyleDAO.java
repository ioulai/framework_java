package fr.eni.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.mvc.bean.Style;

public interface StyleDAO extends JpaRepository<Style, Integer> {

    List<Style> findByOrderByIdAsc();

    List<Style> findByOrderByIdDesc();

    List<Style> findByOrderByLibelleAsc();

    List<Style> findByOrderByLibelleDesc();
}
