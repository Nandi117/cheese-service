package org.example.cheeseservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.cheeseservice.dto.BaseLookupDto;
import org.example.cheeseservice.dto.CreateLookupRequest;
import org.example.cheeseservice.dto.UpdateLookupRequest;
import org.example.cheeseservice.service.RegionService;
import org.example.cheeseservice.service.TextureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/texture")
@RequiredArgsConstructor
public class TextureController {

    private final TextureService service;

    @GetMapping
    public List<BaseLookupDto> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BaseLookupDto byId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public BaseLookupDto create(@RequestBody CreateLookupRequest r) {
        return service.create(r);
    }

    @PutMapping("/{id}")
    public BaseLookupDto update(@PathVariable Long id, @RequestBody UpdateLookupRequest r) {
        return service.update(id, r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
