package com.hibernatemovie.services.franchise;

import com.hibernatemovie.models.Character;
import com.hibernatemovie.models.Franchise;
import com.hibernatemovie.services.CrudService;

import java.util.Collection;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    Collection<Franchise> findByName(String name);
    void updateMoviesInAFranchise(Integer[] movieIDs, Integer franchiseId);
}
