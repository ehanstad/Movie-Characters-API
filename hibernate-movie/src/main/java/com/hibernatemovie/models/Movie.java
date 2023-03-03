package com.hibernatemovie.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 200, nullable = false)
    private String genre;
    @Column(name = "release_year", length = 4, nullable = false)
    private int releaseYear;
    @Column(length = 20)
    private String director;
    @Column(name = "picture_url", length = 200)
    private String pictureURL;
    @Column(name = "trailer_link", length = 200)
    private String trailerLink;
    @ManyToOne
    @JoinColumn(name = "franchise_id", referencedColumnName = "franchise_id")
    private Franchise franchise;
    @ManyToMany
    private Set<Character> characters;
}
