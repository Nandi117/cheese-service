package org.example.cheeseservice.service;

import org.example.cheeseservice.dto.BaseLookupDto;
import org.example.cheeseservice.dto.CreateLookupRequest;
import org.example.cheeseservice.dto.UpdateLookupRequest;

import java.util.List;

public interface MilkTypeService {
    List<BaseLookupDto> findAll();
    BaseLookupDto findById(Long id);
    BaseLookupDto create(CreateLookupRequest r);
    BaseLookupDto update(Long id, UpdateLookupRequest r);
    void delete(Long id);
}
