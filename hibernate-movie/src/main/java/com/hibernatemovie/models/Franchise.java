package com.hibernatemovie.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "franchise")
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "franchise_id")
    private int id;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 250, nullable = false)
    private String description;
    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;
}
