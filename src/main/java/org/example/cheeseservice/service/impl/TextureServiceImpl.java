package org.example.cheeseservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cheeseservice.dto.BaseLookupDto;
import org.example.cheeseservice.dto.CreateLookupRequest;
import org.example.cheeseservice.dto.UpdateLookupRequest;
import org.example.cheeseservice.entity.Texture;
import org.example.cheeseservice.mapper.TextureMapper;
import org.example.cheeseservice.repository.TextureRepository;
import org.example.cheeseservice.service.TextureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TextureServiceImpl implements TextureService {

    private final TextureRepository repo;
    private final TextureMapper mapper;

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
        Texture tx = new Texture();
        tx.setName(r.name());
        tx.setDescription(r.description());
        return mapper.toDto(repo.save(tx));
    }

    @Override
    public BaseLookupDto update(Long id, UpdateLookupRequest r) {
        Texture tx = repo.findById(id).orElseThrow();
        tx.setName(r.name());
        tx.setDescription(r.description());
        return mapper.toDto(repo.save(tx));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
