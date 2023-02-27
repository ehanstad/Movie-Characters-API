package com.hibernatemovie.mappers;

import com.hibernatemovie.models.Character;
import com.hibernatemovie.models.dtos.CharacterDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterDTO characterToCharacterDto(Character character);
    Character characterDtoToCharacter(CharacterDTO characterDTO);
}
