package com.hibernatemovie.services.franchise;

import com.hibernatemovie.models.Franchise;
import com.hibernatemovie.models.Movie;
import com.hibernatemovie.repositories.FranchiseRepository;
import com.hibernatemovie.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, MovieRepository movieRepository) {
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }

    /**
     * Finds a franchise by a movie id
     * @param id an id for a franchise
     * @return an instance of a franchise
     */
    @Override
    public Franchise findById(Integer id) {
        if (id != null)
            return franchiseRepository.findById(id).get();
        return null;
    }

    /**
     * Finds all franchises
     * @return a collection of instances of franchises
     */
    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    /**
     * Adds a franchise to the database
     * @param franchise an instance of the franchise to add
     * @return an instance of a franchise
     */
    @Override
    public Franchise add(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    /**
     * Updates a franchises values in the database
     * @param franchise an instance of the updated franchise
     * @return an instance of a franchise
     */
    @Override
    public Franchise update(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    /**
     * Deletes a franchise with a giving id
     * @param id an id for a franchise
     */
    @Override
    public void deleteById(Integer id) {
        franchiseRepository.deleteById(id);
    }

    /**
     * Finds a collection of franchises that contains the string name
     * @param name a name for a franchise
     * @return a collection of instances of franchises
     */
    @Override
    public Collection<Franchise> findByName(String name) {
        return franchiseRepository.findByName(name);
    }

    /**
     * Updates franchises movies
     * @param movieIDs an array of movie ids
     * @param franchiseId an id for the franchise to update
     */
    @Override
    public void updateMoviesInAFranchise(Integer[] movieIDs, Integer franchiseId) {
        for (int movieId : movieIDs) {
            Movie m = movieRepository.getById(movieId);
            m.setFranchise(franchiseRepository.getById(franchiseId));
            movieRepository.save(m);
        }
    }
}
