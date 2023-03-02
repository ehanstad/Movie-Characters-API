package com.hibernatemovie.services.movie;

import com.hibernatemovie.models.Character;
import com.hibernatemovie.models.Movie;
import com.hibernatemovie.repositories.CharacterRepository;
import com.hibernatemovie.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {
    private final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;

    public MovieServiceImpl(MovieRepository movieRepository, CharacterRepository characterRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
    }

    /**
     * Finds a movie by a movie id
     * @param id an id for a movie
     * @return an instance of a movie
     */
    @Override
    public Movie findById(Integer id) {
        if (id!=null)
            return movieRepository.findById(id).get();
        return null;
    }


    /**
     * Finds a collection of movies that contains the string title
     * @param title a title for movies
     * @return a collection of instances of movies
     */
    @Override
    public Collection<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    /**
     * Finds a collection of movies for a specific genre
     * @param genre a genre for movies
     * @return a collection of instances of movies
     */
    @Override
    public Collection<Movie> findByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    /**
     * Finds a collection of movies for a specific release year
     * @param releaseYear a year for a movies release
     * @return a collection of instances of movies
     */
    @Override
    public Collection<Movie> findByReleaseYear(Integer releaseYear) {
        return movieRepository.findByReleaseYear(releaseYear);
    }

    /**
     * Finds a collection of movies directed by the param director
     * @param director a part of name for a director
     * @return a collection of instances of movies
     */
    @Override
    public Collection<Movie> findByDirector(String director) {
        return movieRepository.findByDirector(director);
    }

    /**
     * Updates a movies characters
     * @param characterIDs an array of character ids
     * @param movieId an id for a movie
     */
    @Override
    public void updateCharactersById(int[] characterIDs, int movieId) {
        Movie movie = movieRepository.getById(movieId);
        Set<Character> characters = new HashSet<>();
        for (int characterId: characterIDs)
            characters.add(characterRepository.getById(characterId));
        movie.setCharacters(characters);
        movieRepository.save(movie);
    }

    /**
     * Finds all movies
     * @return a collection of instances of movies
     */
    @Override
    public Collection<Movie> findAll() {
        return movieRepository.findAll();
    }

    /**
     * Adds a movie to the database
     * @param movie an instance of the movie to add
     * @return an instance of a movie
     */
    @Override
    public Movie add(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Updates a movies values in the database
     * @param movie an instance of the updated movie
     * @return an instance of a movie
     */
    @Override
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Deletes a movie with a giving id
     * @param id an id for a movie
     */
    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }
}
