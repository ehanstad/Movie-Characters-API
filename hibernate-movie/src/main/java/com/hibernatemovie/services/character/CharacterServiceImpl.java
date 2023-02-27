package com.hibernatemovie.services.character;

import com.hibernatemovie.models.Character;
import com.hibernatemovie.repositories.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);
    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * @param integer
     * @return
     */
    @Override
    public Character findById(Integer integer) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Character add(Character entity) {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Character update(Character entity) {
        return null;
    }

    /**
     * @param integer
     */
    @Override
    public void deleteById(Integer integer) {

    }
}
