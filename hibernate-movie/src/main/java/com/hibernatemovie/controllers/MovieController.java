package com.hibernatemovie.controllers;

import com.hibernatemovie.models.Movie;
import com.hibernatemovie.services.movie.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {

    private  final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public ResponseEntity <Collection<Movie>> getAll() {
        return  ResponseEntity.ok(movieService.findAll());
    }
}
