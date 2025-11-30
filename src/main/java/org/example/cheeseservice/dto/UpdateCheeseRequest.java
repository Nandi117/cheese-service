package org.example.cheeseservice.dto;

import java.util.List;

public record UpdateCheeseRequest(
        String name,
        String description,
        Long regionId,
        Long textureId,
        List<Long> milkTypeIds
) {}

