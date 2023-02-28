package com.hibernatemovie.controllers;

import com.hibernatemovie.mappers.CharacterMapper;
import com.hibernatemovie.models.Character;
import com.hibernatemovie.models.dtos.CharacterDTO;
import com.hibernatemovie.services.character.CharacterService;
import com.hibernatemovie.util.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/characters")
public class CharacterController {

    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @Operation(summary = "Get all characters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                description = "Success",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))})
    })
    @GetMapping
    public ResponseEntity<Collection<CharacterDTO>> getAll() {
        Collection<CharacterDTO> chars = characterMapper.characterToCharacterDto(characterService.findAll());
        return ResponseEntity.ok(chars);
    }

    @Operation(summary = "Get character by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                description = "Success",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Character does not exist with supplied ID",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable int id) {
        CharacterDTO charDTO = characterMapper.characterToCharacterDto(characterService.findById(id));
        return ResponseEntity.ok(charDTO);
    }

    @Operation(summary = "Get characters by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Characters does not exist with supplied name",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("search/name")
    public ResponseEntity<Collection<CharacterDTO>> findByName(@RequestParam String name) {
        Collection<CharacterDTO> charsDTO = characterMapper.characterToCharacterDto(characterService.findByName(name));
        return ResponseEntity.ok(charsDTO);
    }

    @Operation(summary = "Get characters by alias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Characters does not exist with supplied alias",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("search/alias")
    public ResponseEntity<Collection<CharacterDTO>> findByAlias(@RequestParam String alias) {
        Collection<CharacterDTO> charsDTO = characterMapper.characterToCharacterDto(characterService.findByAlias(alias));
        return ResponseEntity.ok(charsDTO);
    }

    @Operation(summary = "Get characters by gender")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Characters does not exist with supplied gender",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("search/gender")
    public ResponseEntity<Collection<CharacterDTO>> findByGender(@RequestParam String gender) {
        Collection<CharacterDTO> charsDTO = characterMapper.characterToCharacterDto(characterService.findByGender(gender));
        return ResponseEntity.ok(charsDTO);
    }

    @Operation(summary = "Add character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad request",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PostMapping("add")
    public ResponseEntity add(@RequestBody CharacterDTO character) {
        characterService.add(characterMapper.characterDtoToCharacter(character));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PutMapping("{id}")
    public ResponseEntity updateCharacter(@RequestBody CharacterDTO character, @PathVariable int id) {
        if(id != character.getId())
            return ResponseEntity.notFound().build();
        characterService.update(characterMapper.characterDtoToCharacter(character));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Successfully deleted",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @DeleteMapping("{id}")
    public ResponseEntity deleteCharacter(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
