package com.hibernatemovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character,Integer> {

    List<Character> findAllById(Integer id);

    List<Character> findAllByFullName(String name);

    List<Character> findAllByAlias(String alias);

    List<Character> findAllByGender(String gender);
}
