package com.hibernatemovie.models.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class CharacterDTO {
    private int id;
    private String fullName;
    private String alias;
    private String gender;
    private String pictureURL;
    private Set<Integer> movies;
}
