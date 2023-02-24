package com.hibernatemovie.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(length = 200, nullable = false)
    private String genre;
    @Column(name = "release_year", length = 4, nullable = false)
    private int releaseYear;
    @Column(length = 20, nullable = true)
    private String director;
    @Column(name = "picture_url", length = 100, nullable = true)
    private String pictureURL;
    @Column(name = "trailer_link", length = 100, nullable = true)
    private String trailerLink;
    @ManyToOne
    @JoinColumn(name = "franchise_id", referencedColumnName = "franchise_id")
    private Franchise franchise;
    @ManyToMany
    private Set<Character> characters;
}
