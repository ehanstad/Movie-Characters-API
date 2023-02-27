package com.hibernatemovie.services.movie;

import com.hibernatemovie.models.Movie;
import com.hibernatemovie.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService {
    private Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * @param integer
     * @return
     */
    @Override
    public Movie findById(Integer integer) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Collection<Movie> findAll() {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Movie add(Movie entity) {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Movie update(Movie entity) {
        return null;
    }

    /**
     * @param integer
     */
    @Override
    public void deleteById(Integer integer) {

    }
}
