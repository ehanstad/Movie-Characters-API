package com.hibernatemovie.mappers;

import com.hibernatemovie.models.Character;
import com.hibernatemovie.models.Franchise;
import com.hibernatemovie.models.Movie;
import com.hibernatemovie.models.dtos.MovieDTO;
import com.hibernatemovie.services.character.CharacterService;
import com.hibernatemovie.services.franchise.FranchiseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {
    @Autowired
    protected FranchiseService franchiseService;
    @Autowired
    protected CharacterService characterService;

    @Mapping(target = "franchise", source = "franchise.id")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "charactersToIds")
    public abstract MovieDTO movieToMovieDto(Movie movie);
    @Mapping(target = "franchise", source = "franchise.id")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "charactersToIds")
    public abstract Collection<MovieDTO> moviesToMovieDto(Collection<Movie> movies);

    @Named("charactersToIds")
    Set<Integer> mapCharactersToIds(Set<Character> source) {
        if (source == null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }
    @Mapping(target = "franchise", source = "franchise", qualifiedByName="franchiseIdToFranchise")
    @Mapping(target = "characters", source = "characters", qualifiedByName= "characterIdsToCharacters")
    public abstract Movie movieDtoToMovie(MovieDTO dto);

    @Named("franchiseIdToFranchise")
    Franchise mapIdToFranchise(int id) {
        return franchiseService.findById(id);
    }

    @Named("characterIdsToCharacters")
    Set<Character> mapIdsToCharacters(Set<Integer> ids) {
        if (ids == null)
            return null;
        Set<Character> characters = new HashSet<>();
        ids.stream().map( i -> characters.add(characterService.findById(i)));
        return characters;
    }
}