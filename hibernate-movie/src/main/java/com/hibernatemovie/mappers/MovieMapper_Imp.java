package com.hibernatemovie.mappers;

import com.hibernatemovie.models.Movie;
import com.hibernatemovie.models.dtos.MovieDTO;

public class MovieMapper_Imp implements MovieMapper_I{

    @Override
    public MovieDTO movieToMovieDto(Movie movie) {
        MovieDTO moviedto = new MovieDTO();
        moviedto.setId(movie.getId());
        moviedto.setTitle(movie.getTitle());
        moviedto.setGenre(movie.getGenre());
        moviedto.setReleaseYear(movie.getReleaseYear());
        moviedto.setDirector(movie.getDirector());
        moviedto.setPictureURL(movie.getPictureURL());
        moviedto.setTrailerLink(movie.getTrailerLink());
        return moviedto;
    }

    @Override
    public Movie movieDTOToMovie(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setTitle(dto.getTitle());
        movie.setGenre(dto.getGenre());
        movie.setReleaseYear(dto.getReleaseYear());
        movie.setDirector(dto.getDirector());
        movie.setPictureURL(dto.getPictureURL());
        movie.setTrailerLink(dto.getTrailerLink());

        return movie;
    }
}
