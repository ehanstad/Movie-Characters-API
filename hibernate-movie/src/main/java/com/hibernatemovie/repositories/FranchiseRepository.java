package com.hibernatemovie.repositories;

import com.hibernatemovie.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

    Optional<Franchise> findById (Integer id);

    @Modifying
    @Query("select f from Franchise f where f.name like %?1%")
    List<Franchise> findByName(String name);

}
