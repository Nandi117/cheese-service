package org.example.cheeseservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cheeseservice.dto.BaseLookupDto;
import org.example.cheeseservice.dto.CreateLookupRequest;
import org.example.cheeseservice.dto.UpdateLookupRequest;
import org.example.cheeseservice.entity.MilkType;
import org.example.cheeseservice.mapper.MilkTypeMapper;
import org.example.cheeseservice.repository.MilkTypeRepository;
import org.example.cheeseservice.service.MilkTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MilkTypeServiceImpl implements MilkTypeService {

    private final MilkTypeRepository repo;
    private final MilkTypeMapper mapper;

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
        MilkType mt = new MilkType();
        mt.setName(r.name());
        mt.setDescription(r.description());
        return mapper.toDto(repo.save(mt));
    }

    @Override
    public BaseLookupDto update(Long id, UpdateLookupRequest r) {
        MilkType mt = repo.findById(id).orElseThrow();
        mt.setName(r.name());
        mt.setDescription(r.description());
        return mapper.toDto(repo.save(mt));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
