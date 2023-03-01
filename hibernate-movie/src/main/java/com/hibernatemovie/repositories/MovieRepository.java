package com.hibernatemovie.repositories;

import com.hibernatemovie.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface MovieRepository extends JpaRepository<Movie,Integer > {

    Optional<Movie> findById (Integer id);

    @Modifying
    @Query("select m from Movie m where LOWER (m.title) like LOWER(concat('%', ?1, '%'))")
    List<Movie> findByTitle (String title);

    @Modifying
    @Query("select m from Movie m where LOWER(m.genre) like LOWER(concat('%', ?1, '%'))")
    List<Movie> findByGenre (String genre);

    //@Modifying
    //@Query("select m from Movie m where m.releaseYear like %?1%")
    List<Movie> findByReleaseYear(Integer releaseYear);

    @Modifying
    @Query("select m from Movie m where LOWER(m.director) like LOWER(concat('%', ?1, '%'))")
    List<Movie> findByDirector(String director);

}
