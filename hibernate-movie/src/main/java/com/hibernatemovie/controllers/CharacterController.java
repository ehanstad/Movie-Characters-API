package com.hibernatemovie.controllers;

import com.hibernatemovie.models.Character;
import com.hibernatemovie.services.character.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/characters")
public class CharacterController {

    private final CharacterService characterService;
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity<Collection<Character>> getAll() {
        return  ResponseEntity.ok(characterService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable int id) {
        return ResponseEntity.ok(characterService.findById(id));
    }

    @GetMapping("search/name")
    public ResponseEntity<Collection<Character>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(characterService.findByName(name));
    }

    @GetMapping("search/alias")
    public ResponseEntity<Collection<Character>> findByAlias(@RequestParam String alias) {
        return ResponseEntity.ok(characterService.findByAlias(alias));
    }

    @GetMapping("search/gender")
    public ResponseEntity<Collection<Character>> findByGender(@RequestParam String gender) {
        return ResponseEntity.ok(characterService.findByGender(gender));
    }
}
