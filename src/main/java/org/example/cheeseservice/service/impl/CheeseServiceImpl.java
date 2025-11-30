package org.example.cheeseservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cheeseservice.dto.CheeseDto;
import org.example.cheeseservice.dto.CreateCheeseRequest;
import org.example.cheeseservice.dto.UpdateCheeseRequest;
import org.example.cheeseservice.entity.Cheese;
import org.example.cheeseservice.entity.MilkType;
import org.example.cheeseservice.mapper.CheeseMapper;
import org.example.cheeseservice.repository.*;
import org.example.cheeseservice.service.CheeseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CheeseServiceImpl implements CheeseService {

    private final CheeseRepository cheeseRepo;
    private final RegionRepository regionRepo;
    private final MilkTypeRepository milkRepo;
    private final TextureRepository textureRepo;
    private final CheeseMapper mapper;

    @Override
    public List<CheeseDto> findAll() {
        return cheeseRepo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public CheeseDto findById(Long id) {
        return cheeseRepo.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Cheese not found"));
    }

    @Override
    public CheeseDto create(CreateCheeseRequest r) {

        var region = regionRepo.findById(r.regionId()).orElseThrow();
        var texture = textureRepo.findById(r.textureId()).orElseThrow();

        Set<MilkType> milkTypes = r.milkTypeIds().stream()
                .map(id -> milkRepo.findById(id).orElseThrow())
                .collect(Collectors.toSet());

        Cheese c = Cheese.builder()
                .name(r.name())
                .description(r.description())
                .region(region)
                .texture(texture)
                .milkTypes(milkTypes)
                .build();

        return mapper.toDto(cheeseRepo.save(c));
    }

    @Override
    public CheeseDto update(Long id, UpdateCheeseRequest r) {

        Cheese c = cheeseRepo.findById(id).orElseThrow();

        var region = regionRepo.findById(r.regionId()).orElseThrow();
        var texture = textureRepo.findById(r.textureId()).orElseThrow();

        Set<MilkType> milkTypes = r.milkTypeIds().stream()
                .map(i -> milkRepo.findById(i).orElseThrow())
                .collect(Collectors.toSet());

        c.setName(r.name());
        c.setDescription(r.description());
        c.setRegion(region);
        c.setTexture(texture);
        c.setMilkTypes(milkTypes);

        return mapper.toDto(cheeseRepo.save(c));
    }

    @Override
    public void delete(Long id) {
        cheeseRepo.deleteById(id);
    }

    @Override
    public List<CheeseDto> search(String keyword) {
        return cheeseRepo.search(keyword).stream().map(mapper::toDto).toList();
    }

    @Override
    public List<CheeseDto> findByRegion(String name) {
        return cheeseRepo.findByRegion(name).stream().map(mapper::toDto).toList();
    }


}
