package com.hibernatemovie.mappers;

import com.hibernatemovie.models.Character;
import com.hibernatemovie.models.dtos.CharacterDTO;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class CharacterMapper {


}
