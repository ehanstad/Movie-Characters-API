package com.hibernatemovie.repositories;

import com.hibernatemovie.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

    List<Franchise> findAllById (Integer id);

    List<Franchise> findAllByName(String name);

}
