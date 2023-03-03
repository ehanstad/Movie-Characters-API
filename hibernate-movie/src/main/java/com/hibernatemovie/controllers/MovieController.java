package com.hibernatemovie.controllers;

import com.hibernatemovie.mappers.MovieMapper;
import com.hibernatemovie.models.dtos.MovieDTO;
import com.hibernatemovie.services.movie.MovieService;
import com.hibernatemovie.util.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {

    private  final MovieService movieService;
    private  final MovieMapper movieMapper;


    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper=movieMapper;
    }

    @Operation(summary = "Get all movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = MovieDTO.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "Movie does not exist with supplied ID",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity <Collection<MovieDTO>> getAll() {
        Collection<MovieDTO> movieDTOS = movieMapper.moviesToMovieDto(movieService.findAll());
        return  ResponseEntity.ok(movieDTOS);
    }


    @Operation(summary = "Get a movie by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieDTO.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Movie does not exist with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}")
    public ResponseEntity getBYId(@PathVariable int id) {
        MovieDTO movieDTO = movieMapper.movieToMovieDto(movieService.findById(id));
        return  ResponseEntity.ok(movieDTO);
    }

    @Operation(summary = "Get a movies by title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieDTO.class)) })
    })
    @GetMapping("search/title")
    public  ResponseEntity<Collection<MovieDTO>> findByTitle(@RequestParam String title){
        Collection<MovieDTO> movieDTOS = movieMapper.moviesToMovieDto(movieService.findByTitle(title));
        return  ResponseEntity.ok(movieDTOS);
    }

    @Operation(summary = "Get a movies by genre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieDTO.class)) })
    })
    @GetMapping("search/Genre")
    public  ResponseEntity<Collection<MovieDTO>> findByGenre(@RequestParam String genre){
        Collection<MovieDTO> movieDTOS = movieMapper.moviesToMovieDto(movieService.findByGenre(genre));
        return  ResponseEntity.ok(movieDTOS);
    }

    @Operation(summary = "Get a movies by release year")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieDTO.class)) })
    })
    @GetMapping("search/releaseYear")
    public ResponseEntity<Collection<MovieDTO>> findByReleaseYear(@RequestParam Integer releaseYear){
        Collection<MovieDTO> movieDTOS = movieMapper.moviesToMovieDto(movieService.findByReleaseYear(releaseYear));
        return ResponseEntity.ok(movieDTOS);
    }

    @Operation(summary = "Get a movies by director name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieDTO.class)) })
    })
    @GetMapping("search/director")
    public  ResponseEntity<Collection<MovieDTO>> findByDirector(@RequestParam String director){
        Collection<MovieDTO> movieDTOS = movieMapper.moviesToMovieDto(movieService.findByDirector(director));
        return  ResponseEntity.ok(movieDTOS);
    }

    @Operation(summary = "Add movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MovieDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad request",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PostMapping("add")
    public ResponseEntity add(@RequestBody MovieDTO movieDTO) {
        movieService.add(movieMapper.movieDtoToMovie(movieDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MovieDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PutMapping("update/{id}")
    public ResponseEntity update(@RequestBody MovieDTO movieDTO, @PathVariable int id) {
        if(id != movieDTO.getId() )
            return ResponseEntity.notFound().build();
        movieService.update(
                movieMapper.movieDtoToMovie(movieDTO)
        );
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update a movies character by movie id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MovieDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PutMapping("update/{id}/characters")
    public ResponseEntity updateCharactersById(@RequestBody int[] characterIDs, @PathVariable int id) {
        movieService.updateCharactersById(characterIDs, id);
        return ResponseEntity.ok().build();
    }


    // TODO Create delete function and fix add
    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
