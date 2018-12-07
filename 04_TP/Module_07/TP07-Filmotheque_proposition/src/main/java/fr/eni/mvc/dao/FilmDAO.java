package fr.eni.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.mvc.bean.Film;

public interface FilmDAO extends JpaRepository<Film, Integer> {

    List<Film> findByOrderByTitreAsc();

    List<Film> findByOrderByTitreDesc();

    List<Film> findByOrderByAnneeAsc();

    List<Film> findByOrderByAnneeDesc();

    List<Film> findByOrderByStyleLibelleAsc();

    List<Film> findByOrderByStyleLibelleDesc();

    List<Film> findByOrderByRealAsc();

    List<Film> findByOrderByRealDesc();

    List<Film> findByOrderByDureeAsc();

    List<Film> findByOrderByDureeDesc();

    List<Film> findByOrderByVuAsc();

    List<Film> findByOrderByVuDesc();
}
