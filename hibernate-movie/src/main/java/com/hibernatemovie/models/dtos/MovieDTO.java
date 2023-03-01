package com.hibernatemovie.models.dtos;

import com.hibernatemovie.models.Franchise;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public int getFranchise() {
        return franchise;
    }

    public void setFranchise(int franchise) {
        this.franchise = franchise;
    }

    public Set<Integer> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Integer> characters) {
        this.characters = characters;
    }
}
