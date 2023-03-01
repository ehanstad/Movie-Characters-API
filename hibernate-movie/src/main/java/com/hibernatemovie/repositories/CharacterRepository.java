package com.hibernatemovie.repositories;

import com.hibernatemovie.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character,Integer> {

    Optional<Character> findById(Integer id);
    @Modifying
    @Query("select c from Character c where c.fullName like %?1%")
    List<Character> findAllByFullName(String fullName);

    @Modifying
    @Query("select c from Character c where c.alias like %?1%")
    List<Character> findAllByAlias(String alias);

    List<Character> findAllByGender(String gender);

    List<Character> findByMoviesId(Integer id);

    List<Character> findByMoviesFranchiseId(Integer id);

}
