package org.example.cheeseservice.mapper;


import org.example.cheeseservice.dto.CheeseDto;
import org.example.cheeseservice.entity.Cheese;
import org.example.cheeseservice.entity.MilkType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CheeseMapper {

    @Mapping(source = "region.name", target = "region")
    @Mapping(source = "texture.name", target = "texture")
    @Mapping(target = "milkTypes", expression = "java(mapMilkTypes(cheese.getMilkTypes()))")
    CheeseDto toDto(Cheese cheese);

    default List<String> mapMilkTypes(Set<MilkType> milkTypes) {
        return milkTypes.stream()
                .map(MilkType::getName)
                .toList();
    }
}

