package org.example.cheeseservice.mapper;

import org.example.cheeseservice.dto.BaseLookupDto;
import org.example.cheeseservice.entity.MilkType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MilkTypeMapper {
    BaseLookupDto toDto(MilkType mt);
}
