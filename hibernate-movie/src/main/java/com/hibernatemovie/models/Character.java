package com.hibernatemovie.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 200, nullable = true)
    private String alias;
    @Column(length = 20, nullable = false)
    private String gender;
    @Column(length = 500, name = "picture_URL", nullable = true)
    private String pictureURL;
    @ManyToMany(mappedBy = "characters")
    @JsonIgnore
    private Set<Movie> movies;
}
