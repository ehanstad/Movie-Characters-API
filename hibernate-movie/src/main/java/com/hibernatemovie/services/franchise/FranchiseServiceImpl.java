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
}
