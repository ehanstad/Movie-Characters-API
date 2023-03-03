package com.hibernatemovie.services.movie;

import com.hibernatemovie.models.Movie;
import com.hibernatemovie.services.CrudService;

import java.util.Collection;

public interface MovieService extends CrudService<Movie, Integer> {
    Collection<Movie> findByGenre(String genre);
    Collection<Movie> findByTitle(String title);
    Collection<Movie> findByReleaseYear(Integer year);
    Collection<Movie> findByDirector(String director);
    void updateCharactersById(int[] characterIDs, int movieId);
}
