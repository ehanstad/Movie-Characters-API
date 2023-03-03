package com.hibernatemovie.mappers;

import com.hibernatemovie.models.Character;
import com.hibernatemovie.models.Movie;
import com.hibernatemovie.models.dtos.CharacterDTO;
import com.hibernatemovie.services.movie.MovieService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class CharacterMapper {
    @Autowired
    MovieService movieService;

    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract CharacterDTO characterToCharacterDto(Character character);

    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract Collection<CharacterDTO> characterToCharacterDto(Collection<Character> characters);

    @Named("moviesToIds")
    Set<Integer> map(Set<Movie> source) {
        if (source == null)
            return null;
        return source.stream().map(s -> s.getId()).collect(Collectors.toSet());
    }

    @Mapping(target = "movies", source = "movies", qualifiedByName = "movieIdsToMovies")
    public abstract Character characterDtoToCharacter(CharacterDTO characterDTO);

    @Named("movieIdsToMovies")
    Set<Movie> mapMovieIdsToMovies(Set<Integer> ids) {
        if(ids == null)
            return null;
        Set<Movie> movies = new HashSet<>();
        ids.stream().map(id -> movies.add(movieService.findById(id)));
        return movies;
    }
}
