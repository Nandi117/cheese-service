package org.example.cheeseservice.repository;

import org.example.cheeseservice.entity.Cheese;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheeseRepository extends JpaRepository<Cheese, Long> {
}
