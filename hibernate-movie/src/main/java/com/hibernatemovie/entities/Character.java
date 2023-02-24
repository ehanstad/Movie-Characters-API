package com.hibernatemovie.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String alias;
    @Column(length = 20, nullable = false)
    private String gender;
    @Column(name = "picture_URL", nullable = false)
    private String pictureURL;
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;
}
