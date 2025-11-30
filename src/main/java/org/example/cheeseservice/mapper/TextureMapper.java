package org.example.cheeseservice.mapper;

import org.example.cheeseservice.dto.BaseLookupDto;
import org.example.cheeseservice.entity.Texture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TextureMapper {
    BaseLookupDto toDto(Texture t);
}
