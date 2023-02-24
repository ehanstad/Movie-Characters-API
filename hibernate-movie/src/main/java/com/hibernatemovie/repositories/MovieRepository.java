package com.hibernatemovie.repositories;

import com.hibernatemovie.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer > {

    List<Movie> findAllById (Integer id);

    List<Movie> findByTitle (String title);

    List<Movie> findByGenre (String genre);

    List<Movie> findByReleaseYear(Integer year);

    List<Movie> findByDirector(String director);


}
