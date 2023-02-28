package com.hibernatemovie.services.character;

import com.hibernatemovie.models.Character;
import com.hibernatemovie.services.CrudService;

import java.util.Collection;

public interface CharacterService extends CrudService<Character, Integer> {
    Collection<Character> findByName(String name);

    Collection<Character> findByAlias(String alias);

    Collection<Character> findByGender(String gender);
}
