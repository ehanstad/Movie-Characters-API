package com.hibernatemovie.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "character")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;
    @Column(length = 100, nullable = false, name = "full_name")
    private String fullName;
    @Column(length = 200)
    private String alias;
    @Column(length = 20, nullable = false)
    private String gender;
    @Column(length = 500, name = "picture_URL")
    private String pictureURL;
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;
}
