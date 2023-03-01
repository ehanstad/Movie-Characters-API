package com.hibernatemovie.controllers;

import com.hibernatemovie.mappers.MovieMapper;
import com.hibernatemovie.mappers.MovieMapper_I;
import com.hibernatemovie.mappers.MovieMapper_Imp;
import com.hibernatemovie.models.Movie;
import com.hibernatemovie.models.dtos.MovieDTO;
import com.hibernatemovie.services.movie.MovieService;
import com.hibernatemovie.util.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity <Collection<Movie>> getAll() {
        return  ResponseEntity.ok(movieService.findAll());
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
        return  ResponseEntity.ok(movieService.findById(id));
    }

    @GetMapping("search/title")
    public  ResponseEntity<Collection<Movie>> findByTitle(@RequestParam String title){
        return  ResponseEntity.ok(movieService.findByTitle(title));
    }

    @GetMapping("search/Genre")
    public  ResponseEntity<Collection<Movie>> findByGenre(@RequestParam String genre){
        return  ResponseEntity.ok(movieService.findByGenre(genre));
    }

    @GetMapping("search/releaseYear")
    public  ResponseEntity<Collection<Movie>> findByGenre(@RequestParam Integer releaseYear){
        return  ResponseEntity.ok(movieService.findByReleaseYear(releaseYear));
    }

    @GetMapping("search/director")
    public  ResponseEntity<Collection<Movie>> findByDirector(@RequestParam String director){
        return  ResponseEntity.ok(movieService.findByDirector(director));
    }

    /*
    public ResponseEntity add(@RequestBody Movie movie) {
        Movie movie1 =mo
    }
     */

    @PutMapping("update/{id}") // PUT: localhost:8080/api/v1/movie/update/1
    public ResponseEntity update(@RequestBody MovieDTO movieDTO, @PathVariable int id) {
        // Validates if body is correct
        if(id != movieDTO.getId() )
            return ResponseEntity.notFound().build();
        movieService.update(
                movieMapper.movieDtoToMovie(movieDTO)
        );
        return ResponseEntity.noContent().build();
    }

/*
    @PutMapping("update/{id}") // PUT: localhost:8080/api/v1/movie/update/1
    public ResponseEntity update(@RequestBody MovieDTO movieDTO, @PathVariable int id) {
        // Validates if body is correct
        if(id != movieDTO.getId() )
            return ResponseEntity.notFound().build();
        movieService.update(
                movieMapper_imp.movieDTOToMovie(movieDTO)
        );
        return ResponseEntity.noContent().build();
    }

 */
}
