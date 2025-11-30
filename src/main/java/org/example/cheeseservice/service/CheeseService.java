package org.example.cheeseservice.service;

import org.example.cheeseservice.dto.CheeseDto;
import org.example.cheeseservice.dto.CreateCheeseRequest;
import org.example.cheeseservice.dto.UpdateCheeseRequest;

import java.util.List;

public interface CheeseService {

    List<CheeseDto> findAll();
    CheeseDto findById(Long id);
    CheeseDto create(CreateCheeseRequest request);
    CheeseDto update(Long id, UpdateCheeseRequest request);
    void delete(Long id);

    List<CheeseDto> search(String keyword);
    List<CheeseDto> findByRegion(String name);

}
