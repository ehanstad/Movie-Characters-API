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
     * @param id
     * @return
     */
    @Override
    public Character findById(Integer id) {
        if (id != null)
            return characterRepository.findById(id).get();
        return null;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Collection<Character> findByName(String name) {
        return characterRepository.findAllByFullName(name);
    }

    /**
     * @param alias
     * @return
     */
    @Override
    public Collection<Character> findByAlias(String alias) {
        return characterRepository.findAllByAlias(alias);
    }

    /**
     * @param gender
     * @return
     */
    @Override
    public Collection<Character> findByGender(String gender) {
        return characterRepository.findAllByGender(gender);
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
        if (entity != null)
            return characterRepository.save(entity);
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Character update(Character entity) {
        return characterRepository.save(entity);
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        if (characterRepository.existsById(id)) {
          Character character = characterRepository.findById(id).get();
          character.getMovies().forEach(movie -> movie.setCharacters(null));
          characterRepository.delete(character);
        } else
            logger.warn("No character exists with ID: " + id);
    }
}
