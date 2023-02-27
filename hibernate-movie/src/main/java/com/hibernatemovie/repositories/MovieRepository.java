package com.hibernatemovie.repositories;

import com.hibernatemovie.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Integer > {

    Optional<Movie> findById (Integer id);

    List<Movie> findByTitle (String title);

    List<Movie> findByGenre (String genre);

    List<Movie> findByReleaseYear(Integer year);

    List<Movie> findByDirector(String director);


}
