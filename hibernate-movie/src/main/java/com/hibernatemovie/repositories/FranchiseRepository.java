package com.hibernatemovie.repositories;

import com.hibernatemovie.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

    Optional<Franchise> findById (Integer id);

    List<Franchise> findAllByName(String name);

}
