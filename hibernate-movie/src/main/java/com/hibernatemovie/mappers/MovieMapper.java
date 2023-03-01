package com.hibernatemovie.mappers;

import com.hibernatemovie.models.Character;
import com.hibernatemovie.models.Franchise;
import com.hibernatemovie.models.Movie;
import com.hibernatemovie.models.dtos.MovieDTO;
import com.hibernatemovie.services.character.CharacterService;
import com.hibernatemovie.services.franchise.FranchiseService;
import com.hibernatemovie.services.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {

    @Mapping(target = "franchise", source = "franchise", qualifiedByName = "franchiseToId")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "charactersToIds")
    public abstract MovieDTO movieToMovieDto(Movie movie);
    @Mapping(target = "franchise", source = "franchise", qualifiedByName = "franchiseToId")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "charactersToIds")
    public abstract Collection<MovieDTO> moviesToMoviesDto(Collection<Movie> movies);

    @Named("charactersToIds")
    Set<Integer> mapCharactersToIds(Set<Character> source) {
        if (source == null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }

    @Named("franchiseToId")
    Integer mapFranchiseToId( Franchise franchise) {
        if (franchise == null)
            return null;
        return franchise.getId();
    }


    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "franchise", ignore = true)
    public abstract Movie movieDtoToMovie(MovieDTO dto);

}
