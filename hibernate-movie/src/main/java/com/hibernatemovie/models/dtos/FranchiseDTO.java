package com.hibernatemovie.models.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class FranchiseDTO {
    private int id;
    private String name;
    private String description;
    private Set<Integer> movies;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Integer> getMovies() {
        return movies;
    }

    public void setMovies(Set<Integer> movies) {
        this.movies = movies;
    }
}
