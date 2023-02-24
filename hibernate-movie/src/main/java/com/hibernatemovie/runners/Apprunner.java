package com.hibernatemovie.runners;

import com.hibernatemovie.repositories.CharacterRepository;
import com.hibernatemovie.repositories.FranchiseRepository;
import com.hibernatemovie.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Apprunner implements ApplicationRunner {
    private final CharacterRepository characterRepository;
    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;

    public Apprunner(CharacterRepository characterRepository,
                     FranchiseRepository franchiseRepository,
                     MovieRepository movieRepository) {
        this.characterRepository = characterRepository;
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(characterRepository.findAllById(1).get(0).getName());
    }
}
