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
     * Finds a character by a character id
     * @param id an id for a character
     * @return an instance of a character
     */
    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).get();
    }

    /**
     * Finds a collection of characters that contains the string name
     * @param name a name of a character
     * @return a collection of instances of characters
     */
    @Override
    public Collection<Character> findByName(String name) {
        return characterRepository.findAllByFullName(name);
    }

    /**
     * Finds a collection of characters that contains the string alias
     * @param alias an alias of a character
     * @return a collection of instances of characters
     */
    @Override
    public Collection<Character> findByAlias(String alias) {
        return characterRepository.findAllByAlias(alias);
    }

    /**
     * Finds a collection of characters with a specific gender
     * @param gender a gender of a character
     * @return a collection of instances of characters
     */
    @Override
    public Collection<Character> findByGender(String gender) {
        return characterRepository.findAllByGender(gender);
    }

    /**
     * Finds a collection of characters for a specific movie
     * @param movieId an id for a movie
     * @return a collection of instances of characters
     */
    @Override
    public Collection<Character> findByMovieId(Integer movieId) {
        return characterRepository.findByMoviesId(movieId);
    }

    /**
     * Finds a collection of characters for a specific franchise
     * @param franchiseId an id for a movie
     * @return a collection of instances of characters
     */
    @Override
    public Collection<Character> findByMoviesFranchiseId(Integer franchiseId) {
        return characterRepository.findByMoviesFranchiseId(franchiseId);
    }

    /**
     * Finds all characters
     * @return a collection of instances of characters
     */
    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    /**
     * Adds a character to the database
     * @param character an instance of the character to add
     * @return an instance of a character
     */
    @Override
    public Character add(Character character) {
        if (character != null)
            return characterRepository.save(character);
        return null;
    }

    /**
     * Updates a characters values in the database
     * @param character an instance of the updated character
     * @return an instance of a character
     */
    @Override
    public Character update(Character character) {
        return characterRepository.save(character);
    }

    /**
     * Deletes a character with a giving id
     * @param id an id for a character
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
