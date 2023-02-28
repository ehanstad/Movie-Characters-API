package com.hibernatemovie.runners;

import com.hibernatemovie.services.character.CharacterService;
import com.hibernatemovie.services.franchise.FranchiseService;
import com.hibernatemovie.services.movie.MovieService;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
    private final CharacterService characterService;
    private final FranchiseService franchiseService;
    private final MovieService movieService;

    public AppRunner(CharacterService characterService,
                     FranchiseService franchiseService,
                     MovieService movieService) {
        this.characterService = characterService;
        this.franchiseService = franchiseService;
        this.movieService = movieService;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception { }
}
