package com.hibernatemovie.models.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class MovieDTO {
    private int id;
    private String title;
    private String genre;
    private int releaseYear;
    private String director;
    private String pictureURL;
    private String trailerLink;
    private int franchise;
    private Set<Integer> characters;
}
