package com.hibernatemovie.services.franchise;

import com.hibernatemovie.models.Franchise;
import com.hibernatemovie.repositories.FranchiseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    private Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);
    private FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    /**
     * @param integer
     * @return
     */
    @Override
    public Franchise findById(Integer integer) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Collection<Franchise> findAll() {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Franchise add(Franchise entity) {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Franchise update(Franchise entity) {
        return null;
    }

    /**
     * @param integer
     */
    @Override
    public void deleteById(Integer integer) {

    }
}
