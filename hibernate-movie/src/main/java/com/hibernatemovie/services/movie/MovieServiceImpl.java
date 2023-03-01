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
     * @param id
     * @return
     */
    @Override
    public Movie findById(Integer id) {
        if (id!=null)
            return movieRepository.findById(id).get();
        return null;
    }


    /**
     *
     * @param title
     * @return
     */
    @Override
    public Collection<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    /**
     *
     * @param genre
     * @return
     */
    @Override
    public Collection<Movie> findByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    /**
     *
     * @param releaseYear
     * @return
     */
    @Override
    public Collection<Movie> findByReleaseYear(Integer releaseYear) {
        return movieRepository.findByReleaseYear(releaseYear);
    }

    /**
     *
     * @param director
     * @return
     */
    @Override
    public Collection<Movie> findByDirector(String director) {
        return movieRepository.findByDirector(director);
    }

    /**
     * @return
     */
    @Override
    public Collection<Movie> findAll() {

        return movieRepository.findAll();
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
        return movieRepository.save(entity);
    }

    /**
     * @param integer
     */
    @Override
    public void deleteById(Integer integer) {

    }
}
