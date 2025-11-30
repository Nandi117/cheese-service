package org.example.cheeseservice.dto;

import java.util.List;

public record CheeseDto(
        Long id,
        String name,
        String description,
        String region,
        List<String> milkTypes,
        String texture

) {}
