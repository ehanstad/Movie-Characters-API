package com.hibernatemovie.mappers;

import com.hibernatemovie.models.Movie;
import com.hibernatemovie.models.dtos.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


public interface MovieMapper_I {

    MovieDTO movieToMovieDto(Movie Movie);
    Movie movieDTOToMovie(MovieDTO dto);
}
