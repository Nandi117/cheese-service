package org.example.cheeseservice.repository;

import org.example.cheeseservice.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Long> {
}
