package com.hibernatemovie.repositories;

import com.hibernatemovie.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character,Integer> {

    Optional<Character> findById(Integer id);

    List<Character> findAllByName(String name);

    List<Character> findAllByAlias(String alias);

    List<Character> findAllByGender(String gender);
}
