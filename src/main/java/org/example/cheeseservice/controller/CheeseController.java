package org.example.cheeseservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.cheeseservice.dto.CheeseDto;
import org.example.cheeseservice.dto.CreateCheeseRequest;
import org.example.cheeseservice.dto.UpdateCheeseRequest;
import org.example.cheeseservice.service.CheeseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cheeses")
@RequiredArgsConstructor
public class CheeseController {

    private final CheeseService service;

    @GetMapping
    public List<CheeseDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CheeseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public CheeseDto create(@RequestBody CreateCheeseRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}")
    public CheeseDto update(@PathVariable Long id, @RequestBody UpdateCheeseRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<CheeseDto> search(@RequestParam String keyword) {
        return service.search(keyword);
    }

    @GetMapping("/region/{name}")
    public List<CheeseDto> region(@PathVariable String name) {
        return service.findByRegion(name);
    }
}
