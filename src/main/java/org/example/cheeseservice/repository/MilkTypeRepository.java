package org.example.cheeseservice.repository;

import org.example.cheeseservice.entity.MilkType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilkTypeRepository extends JpaRepository<MilkType, Long> {
}
