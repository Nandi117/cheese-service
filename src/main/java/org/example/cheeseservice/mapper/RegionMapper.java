package org.example.cheeseservice.mapper;

import org.example.cheeseservice.dto.BaseLookupDto;
import org.example.cheeseservice.entity.Region;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegionMapper {
    BaseLookupDto toDto(Region region);
}
