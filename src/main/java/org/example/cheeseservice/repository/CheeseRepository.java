package org.example.cheeseservice.repository;

import org.example.cheeseservice.entity.Cheese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CheeseRepository extends JpaRepository<Cheese, Long> {

    @Query("SELECT c FROM Cheese c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Cheese> search(String keyword);

    @Query("SELECT c FROM Cheese c WHERE LOWER(c.region.name) = LOWER(:name)")
    List<Cheese> findByRegion(String name);


}
