package org.example.cheeseservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cheeseservice.dto.BaseLookupDto;
import org.example.cheeseservice.dto.CreateLookupRequest;
import org.example.cheeseservice.dto.UpdateLookupRequest;
import org.example.cheeseservice.entity.MilkType;
import org.example.cheeseservice.entity.Region;
import org.example.cheeseservice.mapper.RegionMapper;
import org.example.cheeseservice.repository.RegionRepository;
import org.example.cheeseservice.service.RegionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionRepository repo;
    private final RegionMapper mapper;

    @Override
    public List<BaseLookupDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public BaseLookupDto findById(Long id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElseThrow();
    }

    @Override
    public BaseLookupDto create(CreateLookupRequest r) {
        Region rg = new Region();
        rg.setName(r.name());
        rg.setDescription(r.description());
        return mapper.toDto(repo.save(rg));
    }

    @Override
    public BaseLookupDto update(Long id, UpdateLookupRequest r) {
        Region rg = repo.findById(id).orElseThrow();
        rg.setName(r.name());
        rg.setDescription(r.description());
        return mapper.toDto(repo.save(rg));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
