package com.hibernatemovie.services.franchise;

import com.hibernatemovie.models.Franchise;
import com.hibernatemovie.models.Movie;
import com.hibernatemovie.repositories.FranchiseRepository;
import com.hibernatemovie.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    private Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);
    private FranchiseRepository franchiseRepository;
    private MovieRepository movieRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, MovieRepository movieRepository) {
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Franchise findById(Integer id) {
        if (id != null)
            return franchiseRepository.findById(id).get();
        return null;
    }

    /**
     * @return
     */
    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Franchise add(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Franchise update(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        franchiseRepository.deleteById(id);
    }

    /**
     * @param name
     * @return
     */
    @Override
    public Collection<Franchise> findByName(String name) {
        return franchiseRepository.findByName(name);
    }

    /**
     * @param movieIDs
     * @param franchiseId
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
